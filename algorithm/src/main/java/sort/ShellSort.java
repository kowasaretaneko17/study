package sort;

import java.util.Scanner;

/**
 * 构建组：大道金服科技部
 * 作者:weiyimeng
 * 邮箱:weiyimeng@ddjf.com.cn
 * 日期:2019/8/12
 * 功能说明：希尔排序
 * 需求：对大数组表现很好
 * 分组排序，
 * 【通过提升速度来解决其他方式无法解决的问题是研究算法的设计和性能的主要原因之一】
 */
public class ShellSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h<N/3){
            h = 3*h+1;
        }
        while(h>=1){
            //h有序
            for(int i = h;i < N;i++){
                for(int j = i;j>=h && less(a[j],a[j-h]);j -= h){
                    show(a);
                    exch(a,j,j-h);
                }
            }
            h = h/3;
        }
    }
    //检查v是否小于w
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    //交换位置
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private static void show(Comparable[] a){
        //打印数组
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        //是否有序
        for(int i = 1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] a = input.split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
