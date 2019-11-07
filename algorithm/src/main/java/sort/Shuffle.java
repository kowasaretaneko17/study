package sort;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/29
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 * 洗牌算法。
 */
public class Shuffle {
    public static int[] shuffle(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int j = (int)(i+ Math.floor(Math.random()*(arr.length-i)));
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
    public static void main(String[] args){
        int [] arr = {1,2,3,4,5,6,7,8,9,0};
        shuffle(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

}
