package sort;

import java.util.Scanner;

/**
 * 构建组：大道金服科技部
 * 作者:weiyimeng
 * 邮箱:weiyimeng@ddjf.com.cn
 * 日期:2019/8/12
 * 功能说明：归并排序（基于比较排序的算法）
 * 需求：自底向上的归并，先分成很多sz为1的元素对，然后归并成很多数组为2的元素对，以此类推
 */
public class MergeSortBU {
    //辅助数组
    private static Comparable[] aux;
    //原地归并
    public static void merge(Comparable[]a ,int lo,int mid ,int hi){
        //将a[lo...mid]与a[mid+1...hi]归并
        //设置两待归并数据的起始下标
        int i = lo,j = mid+1;
        //把a复制到aux
        for(int k = lo;k<=hi;k++){
            aux[k]=a[k];
        }
        for(int k = lo;k<=hi;k++){
            //如果左半边用尽
            if(i>mid){
                a[k] = aux[j++];
                //右半边用尽
            }else if(j>hi){
                a[k] = aux[i++];
                //右半边当前元素小于左半边的当前元素(取右半边的元素)
            }else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }
    }
    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[a.length];//一次性分配空间
        for(int sz = 1;sz<N;sz = sz+sz){
            for(int lo = 0;lo<N-sz;lo += sz+sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
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
