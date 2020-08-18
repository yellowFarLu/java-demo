package huangy.hythread.uninterrupt;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author huangy on 2019-05-03
 */
public class ReaderThread extends Thread {

    private final Socket socket;
    private final InputStream in;
    public ReaderThread(Socket socket) throws IOException{
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt(){
        try{
            socket.close();
        }catch(IOException ignored){

        }finally{
            super.interrupt();
        }

    }


    public void run(){
        try{
            byte[] buf = new byte[1024];
            while(true){
                int count = in.read(buf);
            }
        } catch(IOException e){
            /*允许线程退出*/
            System.out.println("ReaderThread exists " + e);
        }
    }

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("14.215.177.39", 443);

        ReaderThread thread = new ReaderThread(socket);

        thread.start();

        thread.interrupt();
    }
}

