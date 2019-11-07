/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/30
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num1217 {
    public int minCostToMoveChips(int[] chips) {
        //奇数
        int a = 0;
        //偶数
        int b = 0;
        for(int i = 0;i<chips.length;i++){
            if((chips[i]&1)==0){
                b++;
            }else{
                a++;
            }
        }
        return Math.min(a,b);
    }
    public static void main(String[] args){
        num1217 num = new num1217();
        int[] chips = new int[]{1,2,2};
        num.minCostToMoveChips(chips);
    }
}
