package huangy.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author huangy on 2019-04-21
 */
public class BufferedInputFile {

    public static String read(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));

        String s;

        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }

        in.close();

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String result = BufferedInputFile.read(
                "/Users/huangyuan/Desktop/Study/code/java-demo/src/main/java/huangy/io/BufferedInputFile.java");

        System.out.println(result);
    }

}
