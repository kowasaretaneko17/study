/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/11/6
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num29 {
    public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        long AbsDividend  = Math.abs((long)dividend);
        long AbsDivisor = Math.abs((long)divisor);
        long ans = 0;
        for(int i = 31; i >= 0; i--) {
            //比较dividend是否大于divisor的(1<<i)次方，不要将dividend与(divisor<<i)比较，而是用 (dividend>>i)与divisor比较，
            //效果一样，但是可以避免因(divisor<<i)操作可能导致的溢出，如果溢出则会可能dividend本身小于divisor，但是溢出导致dividend大于divisor
            if((AbsDividend >> i) >= AbsDivisor) {
                ans = ans+(1<<i);
                AbsDividend = AbsDividend-(AbsDivisor<<i);
            }
        }
        int c = dividend^divisor;
        if(c>=0){
            if(Math.abs(ans)>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            return (int)ans;
        }else{
            return -(int)ans;
        }
    }
}
