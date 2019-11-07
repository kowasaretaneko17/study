import java.lang.annotation.Native;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/19
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num7 {
    //定义最小值
    public static final int MIN_VALUE = 0x80000000;
    //定义最大值
    public static final int MAX_VALUE = 0x7fffffff;
    public static int reverse(int x) {
        //先将x转化成字符串(x范围是int所以这一步数据不会有变动)
        String xs = Integer.toString(x);
        //然后判断首位是否为负（默认为正）
        boolean negative = false;
        //因为是整数，所以总是有值的，不可能出现为空或者单符号的情况。所以直接判断
        char header = xs.charAt(0);
        //如果首位为负
        if(header=='-'){
            negative = true;
            xs = xs.substring(1,xs.length());
        }
        //如果首位为正
        else if(header=='+') {
            xs.substring(1, xs.length());
        }
        //转换为整数(因为要在临界值返回0，如果不设置一个更大的接收，那么会直接超界限，返回-1)
        long result = 0;
        //进位
        int carry = 1;
        //123翻转，则就是321，从后向前读，但是对于转换成int，我们还需要拼装一下，拼装规则是原数如果是abc，那么新数就是a+10b+100c，所以直接从首位开始
        for(int i = 0;i<xs.length();i++){
            char zero = '0';
            //ascii码值转换int
            int num = xs.charAt(i)-zero;
            if(negative){
                if(-(num*carry+result)/10<MIN_VALUE/10){
                    return 0;
                }
            }else {
                if((carry/10*num+result/10)>(MAX_VALUE/10)){
                    return 0;
                }
            }
            result = num*carry+result;
            carry = carry*10;
        }
        int end = (int)result;
        return negative?-end:end;
    }
    public static void main(String[] args){
        for(int i = MIN_VALUE;i<MAX_VALUE;i++){
            System.out.println("对于i:"+i+"翻转之后为："+reverse(i));
        }
    }
}
