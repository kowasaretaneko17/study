import java.util.ArrayList;
import java.util.List;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/31
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if(n<1){
            return ans;
        }
        //初始状态
        //最终结果集，当前串，已有左括号数，右括号数，要求的括号对
        ans = returnSearch(ans,"",0,0, n);
        return ans;
    }
    public List<String> returnSearch(List<String> ans,String temp,int left,int right,int n){
        if(left>n||right>left){
            return ans;
        }
        if(left==right&&left==n){
            ans.add(temp);
        }
        ans = returnSearch(ans,temp + "(",left+1,right,n);
        ans = returnSearch(ans,temp + ")",left,right+1,n);
        return ans;
    }
    public static void main(String[] args){
        num22 num22 = new num22();
        List<String> s = num22.generateParenthesis(3);
        for(String a : s){
            System.out.println(a);
        }
    }
}
