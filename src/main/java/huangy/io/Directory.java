package huangy.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author huangy on 2019-04-21
 */
public class Directory {

    public static void main(String[] args) {
        TreeInfo treeInfo = Directory.walk(
                "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference");
        System.out.println(treeInfo);
    }

    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path, String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAllDirsAndFiles(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "files=" + files +
                    ", dirs=" + dirs +
                    '}';
        }

    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                // 如果是文件夹，递归查找该目录下所有目录和文件夹
                result.addAllDirsAndFiles(recurseDirs(item, regex));
            } else {
                // 是文件，并且文件名字匹配，则保存
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
        }

        return result;
    }
}
