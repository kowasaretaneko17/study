package middleSocket;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/9/25
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 * 1、创建ServerSocketChannel并设置相应参数
 * 2、创建Selector并注册到ServerSocketChannel上
 * 3、调用Selector的select方法等待请求
 * 4、Selector接收到请求后使用selectionKeys返回SelectionKey集合
 * 5、使用SelectionKey获取到Channel、Selector和操作类型并进行具体操作
 * ————————————————
 * 原文链接：https://blog.csdn.net/weixin_40096176/article/details/80040204
 */
public class NioServer {
    public static void main(String[] args){
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
