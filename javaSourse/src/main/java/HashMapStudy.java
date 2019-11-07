import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/24
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class HashMapStudy {
    public static void testPut(){
        Map mapNull = new HashMap();
        mapNull.put("1","one");
        System.out.println(mapNull);
        Map mapOne = new HashMap(1);
        mapOne.put("2","two");
        System.out.println(mapOne);
        Map mapMax = new HashMap(Integer.MAX_VALUE);
        mapMax.put("max","max");
        System.out.println(mapMax);
        String s = "111111111111";
        System.out.println(s);

    }

    public static void main(String[] args){
        testPut();
    }

}
