package esay;

/**
 * 构建组：大道金服科技部
 * 作者:weiyimeng
 * 邮箱:weiyimeng@ddjf.com.cn
 * 日期:2019/9/24
 * 功能说明：
 * 需求：
 */
public class MyAtoi {
    private static final int MIN_VALUE = 0X80000000;
    private static final int MAX_VALUE = 0X7FFFFFFF;

    public static int atoi(String s){
        //传入的字符串为空
        if(s==null){
            throw new IllegalArgumentException("当前没有可转换的数据");
        }
        //转化后的数据
        long targetInt = 0;
        int endInt = 0;
        //界限
        int limit = MAX_VALUE;
        //是否为负数
        boolean nagetive = false;
        //s的长度
        int len = s.length();
        //字符串char当前位置
        int i = 0;
        //字符串字符起始位置
        int j = 0;
        //进位
        int radix = 1;
        //判断首位
        if(len>0){
            //char类型比较使用==，并且单引号
            char head = s.charAt(j);
            //不是正常数字开头
            if(head<'0'){
                if('-' == head){
                    nagetive = true;
                    limit = -MIN_VALUE;
                }else {
                    if('+'!=head){
                        throw new IllegalArgumentException("不是标准的数据");
                    }
                    if(len == 1){
                        throw new IllegalArgumentException("不是标准的数据");
                    }
                }
                j++;
            }
        }
        //倒着从个位拿取
        for(i = len-1;i>=j;i--){
            int base = '0';
            char inVal = s.charAt(i);
            //不在数字域内
            if(inVal<'0'|| inVal>'9'){
                throw new IllegalArgumentException("不是标准的数据");
            }
            if(inVal-base>=0){
                if (nagetive) {
                    if(limit>(-targetInt)) {
                        throw new IllegalArgumentException("超出范围");
                    }
                }else{
                    if(limit<targetInt) {
                        throw new IllegalArgumentException("超出范围");
                    }
                }
                targetInt = targetInt + (inVal-base)*radix;
                radix = radix*10;
            }
        }
        endInt = (int)targetInt;
        return nagetive?-endInt:endInt;
    }
    public static void main(String[] args){
        String s = "-1000009";
        int value = atoi(s);
        System.out.println(value);
    }
}
