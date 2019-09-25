package sort;

/**
 * 构建组：游荡的野指针
 * 作者:hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/9/25
 * 功能说明：快排每日练
 * git地址：https://github.com/kowasaretaneko17/
 */
public class QuickSort {

    public static int partition(int arr[],int lo,int high){
        int base = arr[lo];
        while(lo<high){
            while(arr[high]>base && lo<high){
                high--;
            }
            arr[lo] = arr[high];
            while(arr[lo]<base && lo<high){
                lo++;
            }
            arr[high] = arr[lo];
        }
        arr[high] = base;
        return high;
    }
    public static void sort(int arr[],int lo,int high){
        if(lo>high){
            return;
        }
        int index = partition(arr,lo,high);
        sort(arr,lo,index-1);
        sort(arr,index+1,high);
    }
    public static void main(String[] args){
        int[] a = {1,4,6,2,3,5,9,8,7};
        sort(a,0,8);
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
