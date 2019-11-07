
import java.util.ArrayList;
import java.util.List;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/25
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num17 {
    public List<String> letterCombinations(String digits) {
        //结果集
        List<String> ans = new ArrayList<String>();
        if(digits.length()<1){
            return ans;
        }
        String[] str = new String[digits.length()];
        //digits循环
        for(int i = 0;i<digits.length();i++){
            switch(digits.charAt(i)){
                case '2' : str[i] = "abc";break;
                case '3' : str[i] = "def";break;
                case '4' : str[i] = "ghi";break;
                case '5' : str[i] = "jkl";break;
                case '6' : str[i] = "mno";break;
                case '7' : str[i] = "pqrs";break;
                case '8' : str[i] = "tuv";break;
                case '9' : str[i] = "wxyz";break;
                default:
                    return ans;
            }
            ans = getBfs(ans,str[i]);
        }
        return ans;
    }
    public List<String> getBfs(List<String> ans,String digit){
        List<String> tempL = new ArrayList<String>();
        if(ans.size()>0){
            for(String s : ans){
                for(int i = 0;i<digit.length();i++){
                    String temp = s+digit.charAt(i);
                    tempL.add(temp);
                }
            }
        }else{
            for(int i = 0;i<digit.length();i++){
                String temp = String.valueOf(digit.charAt(i));
                tempL.add(temp);
            }
        }
        return tempL;
    }
    public static void main(String[] args){
        num17 num17 = new num17();
        List<String> s = num17.letterCombinations("234");
        for(String s1:s){
            System.out.println(s1);
        }
    }
}
