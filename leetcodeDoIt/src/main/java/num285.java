/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/18
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num285 {
    public static int solution(int s){
        if(s>=0){
            if(s<10){
                return s;
            }else{
                s=s%9;
                return s;
            }
        }else {
            throw new IllegalArgumentException("数字不符合题目要求");
        }
    }
    public static void main(String[] args){
        int s = solution(38);
        System.out.println(s);
    }
}
