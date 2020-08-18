package huangy.io;

import java.io.File;
import java.io.IOException;

/**
 * @author huangy on 2019-04-21
 */
public class ProcessFiles {

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;

    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        // 接收一个策略
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        if (!arg.endsWith("." + ext)) {
                            arg += "." + ext;
                        }

                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath())) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[1];
        arr[0] = "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference";

        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(arr);
    }
}
