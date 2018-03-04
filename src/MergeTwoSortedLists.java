import java.util.List;

/**
 * Created by liuwenxiu on 2018/1/3.
 */


public class MergeTwoSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x,ListNode listNode){
            val = x;
            next = listNode;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 ==null){
            return l1;
        }
        if(l1==null && l2==null){
            return null;
        }
        ListNode head = l1.val<=l2.val?l1:l2;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmp = head;

        if(l1.val <= l2.val){
            head = l1;
            tmp1= tmp1.next;
        }
        else{
            head = l2;
            tmp2 = tmp2.next;
        }
        while (tmp1 != null && tmp2 != null){
            if(tmp1.val<= tmp2.val){
                tmp.next  = tmp1;
                tmp = tmp1;
                tmp1 = tmp1.next;
            }else {
                tmp.next = tmp2;
                tmp = tmp2;
                tmp2 = tmp2.next;
            }
        }
        tmp.next = (tmp1==null)?tmp2:tmp1;
        return head;
    }
    public static void main(String[] args) throws Exception{
        //ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        //ListNode l2 = new ListNode(1,new ListNode(2,new ListNode(3,null)));
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode result = new MergeTwoSortedLists().mergeTwoLists(l1,l2);
        System.out.println(result);
    }
}
