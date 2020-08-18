package huangy.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author huangy on 2019-04-21
 */
public class OSExecute {

    public static void command(String command) {
        boolean err = false;

        try {
            // 执行命令
            Process process = new ProcessBuilder(command.split(" ")).start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream()
                    )
            );

            String s;

            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }

            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );

            while ((s = errors.readLine()) != null) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OSExecute.command("ls");
    }

}
