package sort;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/9/25
 * 功能说明：堆排每日练
 * git地址：https://github.com/kowasaretaneko17/
 */
public class HeapSort {

    public static void swap(int[] arr,int i,int max){
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
    }
    public static void heapify(int[] arr,int n,int i){
        if(i>=n){
            return;
        }
        int leftChild = i*2+1;
        int rightChild = i*2+2;
        int max = i;
        if(leftChild<n && arr[leftChild]>arr[max]){
            max = leftChild;
        }
        if(rightChild<n && arr[rightChild]>arr[max]){
            max = rightChild;
        }
        if(i!=max){
            swap(arr,i,max);
            heapify(arr,n,max);
        }
    }
    public static void buildHeap(int[] arr,int n){
        if(n<1){
            return;
        }
        int last = n-1;
        int parent = (last-1)/2;
        for(int i = parent;i>=0;i--){
            heapify(arr,n,i);
        }
    }
    public static void sort(int[] arr,int n){
        if(n<1){
            return;
        }
        buildHeap(arr,n);
        for(int i = n-1;i>=0;i--){
            swap(arr,i,0);
            buildHeap(arr,i);
        }
    }
    public static void main(String[] args){
        int[] a = {1,4,6,2,3,5,9,8,7};
        sort(a,a.length);
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
