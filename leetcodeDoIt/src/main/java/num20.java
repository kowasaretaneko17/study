import java.util.Stack;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/30
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num20 {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for(int i = 0;i<s.length();i++){
            if(!stack.empty()){
                if(s.charAt(i)=='}'){
                    if((Character)stack.peek()=='{'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else
                if(s.charAt(i)==']'){
                    if((Character)stack.peek()=='['){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else
                if(s.charAt(i)==')'){
                    if((Character)stack.peek()=='('){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
