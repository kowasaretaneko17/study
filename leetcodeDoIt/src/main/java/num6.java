//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 构建组：游荡的野指针
// * 作者：hekiraku
// * 邮箱:1239407570@qq.com
// * 日期:2019/10/18
// * 功能说明：
// * git地址：https://github.com/kowasaretaneko17/
// */
//public class num6 {
//   //我的妈呀，大神太牛皮了日了狗，想了一个小时想不出来，手动拜拜
//    //思路，设置numRows个数组
//   public String convert(String s, int numRows) {
//       //结果集
//       List<StringBuffer> result = new ArrayList<StringBuffer>();
//       //生成结果集
//       for(int k = 0;k<numRows;k++){
//           StringBuffer stringBuffer = new StringBuffer();
//           result.add(stringBuffer);
//       }
//       boolean flag = true;
//       for(int i = 0;i<s.length();i++){
//           for(int j = 0;j<numRows;j++){
//               result.get(j).append(s.charAt(i++));
//           }
//       }
//
//   }
//}
