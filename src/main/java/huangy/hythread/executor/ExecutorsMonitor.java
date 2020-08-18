package huangy.hythread.executor;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 线程池监控
 * 通过继承线程池，重写beforeExecute()、afterExecute()方法实现
 *
 */
public class ExecutorsMonitor extends ThreadPoolExecutor {

    private static final Logger LOGGER = Logger.getLogger(ExecutorsMonitor.class);

    // 保存任务开始执行的时间,当任务结束时,用任务结束时间减去开始时间计算任务执行时间
    private ConcurrentHashMap<String, Date> startTimes;
    // 线程池名称,一般以业务名称命名,方便区分
    private String poolName;
    /**
     * 调用父类的构造方法,并初始化HashMap和线程池名称
     *
     * @param corePoolSize
     * 线程池核心线程数
     * @param maximumPoolSize
     * 线程池最大线程数
     * @param keepAliveTime
     * 线程的最大空闲时间
     * @param unit
     * 空闲时间的单位
     * @param workQueue
     * 保存被提交任务的队列
     * @param poolName
     * 线程池名称
     */
    public ExecutorsMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue workQueue,
                            String poolName) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                new EventThreadFactory(poolName));
        this.startTimes = new ConcurrentHashMap<>();
        this.poolName = poolName;
    }
    /**
     * 线程池延迟关闭时(等待线程池里的任务都执行完毕),统计线程池情况
     */
    @Override
    public void shutdown() {
        // 统计已执行任务、正在执行任务、未执行任务数量
        LOGGER.info(String.format(this.poolName + " Going to shutdown. Executed tasks: %d, Running tasks: %d, Pending tasks: %d",
                this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size()));
        super.shutdown();
    }
    /**
     * 线程池立即关闭时,统计线程池情况
     */
    @Override
    public List shutdownNow() {
        // 统计已执行任务、正在执行任务、未执行任务数量
        LOGGER.info(
                String.format(this.poolName + " Going to immediately shutdown. Executed tasks: %d, Running tasks: %d, Pending tasks: %d",
                        this.getCompletedTaskCount(), this.getActiveCount(), this.getQueue().size()));
        return super.shutdownNow();
    }
    /**
     * 任务执行之前,记录任务开始时间
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTimes.put(String.valueOf(r.hashCode()), new Date());
    }
    /**
     * 任务执行之后,计算任务结束时间
     */
    @Override
    protected void afterExecute(Runnable r, Throwable t) {

        Date startDate = startTimes.remove(String.valueOf(r.hashCode()));
        Date finishDate = new Date();

        long diff = finishDate.getTime() - startDate.getTime();

        // 统计任务耗时、初始线程数、核心线程数、正在执行的任务数量、已完成任务数量、任务总数、
        // 队列里缓存的任务数量、池中存在的最大线程数、最大允许的线程数、线程空闲时间、线程池是否关闭、线程池是否终止
        LOGGER.info(String.format(this.poolName
                        + "-pool-monitor: Duration: %d ms, PoolSize: %d, CorePoolSize: %d, ActiveCount: %d, " +
                        "CompletedTaskCount: %d, TaskCount: %d, QueueSize: %d, LargestPoolSize: %d, MaximumPoolSize: %d," +
                        "KeepAliveTime: %d, isShutdown: %s, isTerminated: %s",
                diff, this.getPoolSize(), this.getCorePoolSize(), this.getActiveCount(), this.getCompletedTaskCount(), this.getTaskCount(),
                this.getQueue().size(), this.getLargestPoolSize(), this.getMaximumPoolSize(), this.getKeepAliveTime(TimeUnit.MILLISECONDS),
                this.isShutdown(), this.isTerminated()));
    }

    /**
     * 创建固定线程池,代码源于Executors.newFixedThreadPool方法,这里增加了poolName
     *
     * @param nThreads
     * 线程数量
     * @param poolName
     * 线程池名称
     * @return ExecutorService对象
     */
    public static ExecutorService newFixedThreadPool(int nThreads, String poolName) {
        return new ExecutorsMonitor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue (), poolName);
    }

    /**
     * 创建缓存型线程池,代码源于Executors.newCachedThreadPool方法,这里增加了poolName
     *
     * @param poolName
     * 线程池名称
     * @return ExecutorService对象
     */
    public static ExecutorService newCachedThreadPool(String poolName) {
        return new ExecutorsMonitor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue (), poolName);
    }

    /**
     * 生成线程池所用的线程,只是改写了线程池默认的线程工厂,传入线程池名称,便于问题追踪
     */
    static class EventThreadFactory implements ThreadFactory {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);

        private final ThreadGroup group;

        private final AtomicInteger threadNumber = new AtomicInteger(1);

        private final String namePrefix;

        /**
         * 初始化线程工厂
         *
         * @param poolName
         * 线程池名称
         */
        EventThreadFactory(String poolName) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = poolName + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}