package sort;

import java.util.Scanner;

/**
 * 构建组：大道金服科技部
 * 作者:weiyimeng
 * 邮箱:weiyimeng@ddjf.com.cn
 * 日期:2019/8/12
 * 功能说明：
 * 需求：选择排序练习
 * 思路：选择排序是跟着下标走，每次循环都找出最小的值，然后跟下标位置交换。
 */
public class SelectionSort {
    public static void sort(Comparable[] a){
        for(int i = 0;i<a.length;i++){
            int minIndex = i;
            for(int j = i;j<a.length;j++){
                if(less(a[j],a[minIndex])){
                    minIndex = j;
                }
            }
            exch(a,i,minIndex);
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
