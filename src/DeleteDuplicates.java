/**
 * Created by liuwenxiu on 2018/2/18.
 */
public class DeleteDuplicates {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x,ListNode listNode){
            val = x;
            next = listNode;
        }
    }
    public ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return null;
        }
        ListNode now = head.next;
        ListNode prev = head;
        while (now != null){
            if(now.val == prev.val){
                prev.next  = now.next;
            }else {
                prev =now;
            }
            now = now.next;
        }
        return head;
    }
    public  static  void main(String args[]){
        ListNode l1 = new ListNode(1,null);
        ListNode result  = new DeleteDuplicates().deleteDuplicates(l1);
    }
}
