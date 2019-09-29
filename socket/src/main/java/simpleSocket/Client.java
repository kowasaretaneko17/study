package simpleSocket;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.io.*;
import java.net.Socket;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/9/25
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",60000);
            //发送信息流
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("【客户端：】我是客户端：你好呀！！！");
            //将缓冲区的数据强制输出，用于清空缓冲区，若直接调用close()方法，则可能会丢失缓冲区的数据。所以通俗来讲它起到的是刷新的作用。
            //而且如果不flush，服务端其实接收不到这边的信息的。尴尬哦！
            printWriter.flush();
            //关闭输出流
            socket.shutdownOutput();

            //接收信息流
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String info  = bufferedReader.readLine();
            if(info!=null){
                System.out.println("【客户端：】读取服务端消息————：");
                System.out.println(info);
            }
            //关闭所有流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
