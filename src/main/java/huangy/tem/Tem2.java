package huangy.tem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登陆安全的题目，如果你的系统登陆接口在被刷。我们要建立一个防刷系统。
 * 根据登陆ip，30分钟之内，只能请求30次登陆请求，如果超过这个限制，则整个ip限制登陆请求30分钟
 * @author huangy on 2020-03-30
 */
public class Tem2 {

    private static final Long MIN_30 = 30 * 60 * 1000L;

    // 后期可以优化成多个请求队列，不同业务使用不同的请求队列
    private static List<Node> requestList = new ArrayList<>();

    // 黑名单
    private static Map<String, Node> black = new HashMap<>();

    static class Node {

        /**
         * 请求ip地址
         */
        private String ip;

        /**
         * 请求时间
         */
        private Long requestTime;

        /**
         * 黑名单过期时间
         */
        private Long blackTime;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Long getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(Long requestTime) {
            this.requestTime = requestTime;
        }

        public Long getBlackTime() {
            return blackTime;
        }

        public void setBlackTime(Long blackTime) {
            this.blackTime = blackTime;
        }
    }

    /**
     * （1）是否在黑名单中，在的话，判断是否黑名单时间小于30分钟
     *       a、是，则不给请求
     *       b、否，移出黑名单
     * （2）判断最近30分钟内该IP是否有超过30个请求
     * （3）如果没有，则新的请求入队
     * （4）如果有，加入黑名单，设置黑名单过期时间
     * @param ip 请求ip
     */
    public static void checkRequest(String ip) throws Exception {

        if ((ip == null) || "".equals(ip)) {
            throw new Exception("参数错误，拒绝请求");
        }

        Node blackNode = black.get(ip);

        if (blackNode != null) {
            if (blackNode.getBlackTime() >= System.currentTimeMillis()) {
                throw new Exception("IP在黑名单中，拒绝请求");
            } else {
                // 已经过了黑名单截止时间，则移除黑名单
                black.remove(ip);
            }
        }

        int count = 0;
        for (Node tem : requestList) {
            if ((tem.getRequestTime() >= (System.currentTimeMillis() - MIN_30))
                    && ip.equals(tem.getIp())) {

                // 统计过去30分内该IP的请求
                count++;

                // 哨兵
                if (count > 30) {
                    break;
                }
            }
        }

        if (count > 30) {
            // 非法请求，加入黑名单
            Node node = new Node();
            node.setIp(ip);
            node.setBlackTime(System.currentTimeMillis() + MIN_30);

            black.put(ip, node);

            throw new Exception("最近30分钟的请求超过30次，拒绝请求");
        }

        // 加入请求队列
        Node node = new Node();
        node.setIp(ip);
        node.setRequestTime(System.currentTimeMillis());
        requestList.add(node);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            try {
                checkRequest("127.0.0.1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
