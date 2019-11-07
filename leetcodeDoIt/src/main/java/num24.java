/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/11/1
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num24 {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode swapPairs(ListNode head) {
         //先按照位置的奇偶拆分成两条链表，再重新合并
        boolean odd = true;
        if(head==null||head.next==null){
            return head;
        }
        //奇数
        ListNode oddPre = new ListNode(-1);
        ListNode evenPre = new ListNode(0);
        ListNode oddCurr = oddPre;
        ListNode evenCurr = evenPre;
        ListNode curr = head;
        while(curr!=null){
            if(odd){
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
                odd = false;
            }else {
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
                odd = true;
            }
            curr = curr.next;
        }
        if(odd==false){
            evenCurr.next = null;
        }else {
            oddCurr.next = null;
        }
        odd = false;
        ListNode pre = new ListNode(0);
        ListNode ansCurr = pre;
        while(oddPre.next!=null&&evenPre.next!=null){
            if(odd){
                ListNode temp = new ListNode(oddPre.next.val);
                ansCurr.next = temp;
                oddPre = oddPre.next;
                odd = false;
            }else {
                ListNode temp = new ListNode(evenPre.next.val);
                ansCurr.next = temp;
                evenPre = evenPre.next;
                odd = true;
            }
            ansCurr = ansCurr.next;
        }
        if(oddPre.next==null){
            ansCurr.next = evenPre.next;
        }
        if(evenPre.next==null){
            ansCurr.next = oddPre.next;
        }
        return pre.next;
    }
    public static void main(String[] args){
         num24 num24 = new num24();
         ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6= new ListNode(7);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        num24.swapPairs(listNode);

    }
}
