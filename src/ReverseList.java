import java.util.List;

/**
 * Created by liuwenxiu on 2018/2/14.
 */
public class ReverseList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x,ListNode listNode){
            val = x;
            next = listNode;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode now = head;
        while(now != null){
            ListNode next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
    }
    public static void main(String[] args) throws Exception{
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode result = new ReverseList().reverseList(l1);
        System.out.println(result);
    }
}
