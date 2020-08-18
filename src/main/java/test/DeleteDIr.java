package test;

import java.io.File;

/**
 * @author huangy on 2020-05-19
 */
public class DeleteDIr {

    public static void main(String[] args) {

        String rootPath = "tem/image/word/media/";

        File root = new File(rootPath);
        deleteDir(root);
    }

    private static void deleteDir(File dir) {
        if (!dir.exists()) {
            return;
        }

        boolean tag = dir.delete();
        if (!tag) {
            System.out.println("deleteDirectory delete dir fail, dirPath="
                    + dir.getAbsolutePath());
        }
    }
}
