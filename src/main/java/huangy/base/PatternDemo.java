package huangy.base;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author huangy on 2020-05-02
 */
public class PatternDemo {

    private static Pattern ROUTE_PATTERN = Pattern.compile("([&!=,]*)\\s*([^&!=,\\s]+)");

    public static void main(String[] args) {
        final Matcher matcher = ROUTE_PATTERN.matcher("host = 2.2.2.2 & host != 1.1.1.1 & method = hello");

        while (matcher.find()) {

            // 获取括号一内的匹配结果
            String separator = matcher.group(1);

            // 获取括号二内的匹配结果
            String content = matcher.group(2);

            System.out.println(separator + "    " + content);
        }
    }
}
