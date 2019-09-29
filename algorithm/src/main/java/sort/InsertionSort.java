package sort;

import java.util.Scanner;

/**
 * 构建组：大道金服科技部
 * 作者:weiyimeng
 * 邮箱:weiyimeng@ddjf.com.cn
 * 日期:2019/8/12
 * 功能说明：插入排序
 * 需求：当前下标对应的值，和其左侧有序的值比较，插入到其有序数列中
 */
public class InsertionSort {
    public static void sort(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            for(int j = i;j>0 && less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
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
