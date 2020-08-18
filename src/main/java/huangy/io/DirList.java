package huangy.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author huangy on 2019-04-21
 */
public class DirList {

    public static void main(String[] args) {
        // 获取某个目录的下的一组文件
        File path = new File(
                "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/hyreference");

        // 利用文件夹过滤器，过滤出符合正则的文件
        // 这里是过滤出java后缀的文件
        DirFilter dirFilter = new DirFilter(Pattern.compile(".*\\.java"));
        String[] list = path.list(dirFilter);

        System.out.println(Arrays.toString(list));
    }

}

class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(Pattern pattern) {
        this.pattern = pattern;
    }

    // 每一个文件都会回调这个方法进行过滤
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}