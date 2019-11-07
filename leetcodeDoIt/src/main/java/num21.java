/**
 * 构建组：游荡的野指针
 * 作者：hekiraku
 * 邮箱:1239407570@qq.com
 * 日期:2019/10/31
 * 功能说明：
 * git地址：https://github.com/kowasaretaneko17/
 */
public class num21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            curr.next=l2;
        }
        if(l2==null){
            curr.next=l1;
        }
        return pre.next;
    }
}
