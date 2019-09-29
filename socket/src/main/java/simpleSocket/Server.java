package simpleSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/9/25
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class Server {
    public static void main(String[] args){
        try {
            System.out.println("【服务端：】服务端启动！");
            ServerSocket server = new ServerSocket(60000);
            Socket socket = server.accept();
            System.out.println("【服务端：】监听到客户端连接！"+socket.getInetAddress());
            //读取数据流
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String info = bufferedReader.readLine();
            if(info!=null){
                System.out.println("【服务端：】读取客户端信息————：");
                System.out.println(info);
            }

            //回复消息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("【服务端：】我是服务端！你好呀！");
            printWriter.flush();

            //关闭输出流
            socket.shutdownOutput();
            //关闭所有流
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
//            server.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }

    }
}
