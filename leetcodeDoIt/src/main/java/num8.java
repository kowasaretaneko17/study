/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/19
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num8 {
    public static final int MIN_VALUE = 0x80000000;
    public static final int MAX_VALUE = 0X7fffffff;
    public int myAtoi(String str) {
        //结果集
        long result = 0;
        //进位
        long carry = 1;
        //默认为正数
        boolean negative = false;
        //字符串长度
        int len = str.length();
        //标记数字段的起始和结束
        int start = 0;
        int end = len;
        //找到头部，切换尾部(false表示正在找头部位置)
        boolean findHead = false;
        //符号位下标
        int mark = -1;
        //处理空字符串
        if(len==0 || str==null){
            return 0;
        }
        //剥出有用信息
        for(int i = 0;i<len;i++){
            //去掉最前端的空白字符
            if(!findHead && str.charAt(i)==' '){
                start = i+1;
            }else
                //检测非法字符,如果不是数字
                if(!isNum(str.charAt(i))){
                    //遇到了不是''的值，所以不再找头部了，开始找尾部
                    findHead = true;
                    //如果不是'-'或者'+'，记录end值，跳出循环。
                    if(!(str.charAt(i)=='-'||str.charAt(i)=='+')){
                        end = i;
                        break;
                    }else{
                        //对于已经有一个标记位的当做结束位处理
                        if(mark >=0){
                            end = i;
                            break;
                        }else {
                            mark = i+1;
                            if(mark-start>1){
                                end = i;
                                break;
                            }
                        }
                    }
                }else{
                    findHead = true;
                }
        }
        //截取数字段和符号段
        str = str.substring(start,end);
        //符号位
        if(mark-start==1){
            if(str.charAt(0)=='-'){
                negative = true;
            }
            //去符号位
            if(str.length()>1){
                str = str.substring(1,str.length());
            } else {
                return 0;
            }
        }
        int realStart = 0;
        //处理边界0
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                realStart++;
                continue;
            }else {
                break;
            }
        }
        str = str.substring(realStart,str.length());
        //大数边界
        if(str.length()>11){
            if(negative){
                return MIN_VALUE;
            }else {
                return MAX_VALUE;
            }
        }
        //去零后长度
        if(str.length()==0){
            return 0;
        }
        //atoi
        for(int i = str.length()-1;i>=0;i--){
            char zero = '0';
            //ascii码值转换int
            if(isNum(str.charAt(i))){
                long num = str.charAt(i)-zero;
                result = num*carry+result;
                carry = carry*10;
                if(negative){
                    if(-result<(long) MIN_VALUE){
                        return MIN_VALUE;
                    }
                }else {
                    if(result>(long) MAX_VALUE){
                        return MAX_VALUE;
                    }
                }
            }
        }
        return negative?-(int)result:(int)result;

    }
    //数字检测器
    public boolean isNum(char a){
        if(a>='0'&&a<='9'){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        num8 num8 = new num8();
        System.out.println(num8.myAtoi("-10000000000000000000000000000000199"));
    }
}
