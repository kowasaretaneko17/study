package tree;

import jdk.nashorn.internal.ir.Block;

import java.util.Map;
import java.util.concurrent.RejectedExecutionHandler;

/**
 * 构建组：大道金服科技部
 * 作者:weiyimeng
 * 邮箱:weiyimeng@ddjf.com.cn
 * 日期:2019/9/17
 * 功能说明：
 * 需求：红黑树
 * 一、红链接均为左链接
 * 二、没有任何一个结点同时和两条红链接相连
 * 三、该树完美黑色平衡，即任意空链接到根节点的路径上的黑链接数量相同
 */
public class BlackRed<K extends Comparable<K>,V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    //红黑树结点定义
    private class Node{
        private K key;
        private V value;
        private Node left;
        private Node right;
        //每个结点都会有一条指向它的链接，将链接的颜色保存下来（约定空链接为黑色）
        private boolean color;
        //以该结点为根的子树中的结点总数
        private int N;

        Node(K key,V value,int N,boolean color){
            this.key = key;
            this.value = value;
            this.color = color;
            this.N = N;
        }
    }
    private boolean isRed(Node n){
        //空节点
        if(n ==null){
            return false;
        }
        return n.color;
    }
    private int size(Node n){
        if(n==null){
            return 0;
        }
        return n.N;
    }

      /////////////////////////////////////////////////
      // ps：链接单线为黑链接，双线为红链接
      //    |                            |
      //    E                            S
      //  /  \\      左旋E的右链接      //  \
      // A    S       --------->     E     T
      //     / \                   /  \
      //    F   T                A     F
      //////////////////////////////////////////////////
    //旋转结点E的红色右链接（如上图）
    Node rotateLeft(Node e){
        //结点S
        Node s = e.right;
        //E的右结点变成之前S的左结点，即F结点
        e.right = s.left;
        //S的左结点变成E结点
        s.left = e;
        //指向S的链接颜色是之前指向E的链接颜色
        s.color = e.color;
        //指向E的链接颜色变成红色
        e.color = RED;
        //S的子节点
        s.N = e.N;
        e.N = 1+size(e.left)+size(e.right);
        return s;
    }
    /////////////////////////////////////////////////
    // ps：链接单线为黑链接，双线为红链接
    //    |                            |
    //    E                            S
    //  /  \\      右旋S的左链接      //  \
    // A    S       <---------     E     T
    //     / \                   /  \
    //    F   T                A     F
    //////////////////////////////////////////////////
    //右旋
    Node rotateRight(Node s){
        Node e = s.left;
        s.left = e.right;
        e.right = s;
        e.color = s.color;
        s.color = RED;
        e.N = s.N;
        s.N = 1+size(s.left)+size(s.right);
        return e;
    }
    /////////////////////////////////////////////////
    // ps：链接单线为黑链接，双线为红链接
    //    |                            ||
    //    N                            N
    //  // \\          转换颜色       /  \
    // A     S       ---------->    E    T
    //
    //////////////////////////////////////////////////
    //颜色转换
    void flipColor(Node n){
        n.color = RED;
        n.left.color = BLACK;
        n.right.color = BLACK;
    }

    //插入操作
    public void put(K key,V value){
        //查找key，如果找到就更新值，否则插入一个新的结点
        root = put(root,key,value);
        root.color = BLACK;
    }
    public Node put(Node n,K key,V value){
        //插入，与父结点用红链接连接
        if(n==null){
            return new Node(key,value,1,RED);
        }
        int cmp = key.compareTo(n.key);
        if(cmp<0){
            n.left = put(n.left,key,value);
        }else if(cmp>0){
            n.right = put(n.right,key,value);
        }else {
            n.value = value;
        }

        //如果右链接是红色，左链接是黑色
        if(isRed(n.right)&&!isRed(n.left)){
            n = rotateLeft(n);
        }
        //如果左链接是红色，且左链接的左链接是红色
        if(isRed(n.left)&&isRed(n.left.left)){
            n = rotateRight(n);
        }
        //如果左链接和右链接都是红色
        if(isRed(n.left)&&isRed(n.right)){
            flipColor(n);
        }
        n.N = size(n.left) +size(n.right)+1;
        return n;
    }
    public void delete(Node n){

    }




}
