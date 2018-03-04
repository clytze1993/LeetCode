import java.util.List;

/**
 * Created by liuwenxiu on 2018/2/27.
 */
public class GetIntersectionNode {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x, ListNode listNode){
            val = x;
            next = listNode;
        }
    }
    public ListNode getIntersectionNode(ListNode headA ,ListNode headB){
        ListNode tmpA1 = headA;
        ListNode tmpB1 = headB;
        int lenA = 0;
        int lenB = 0;
        while (tmpA1!=null){
            lenA = lenA +1;
            tmpA1 = tmpA1.next;
        }
        while (tmpB1!=null){
            lenB = lenB +1;
            tmpB1 = tmpB1.next;
        }
        ListNode tmpA2 = headA;
        ListNode tmpB2 = headB;
        if(lenA > lenB){
            int len = lenA-lenB;
            for(int i=0;i<len;i++){
                tmpA2 = tmpA2.next;
            }
        }
        else if(lenA < lenB){
            int len = lenB - lenA;
            for(int i = 0; i<len;i++){
                tmpB2 = tmpB2.next;
            }
        }
        while (tmpA2 !=null && tmpB2 !=null){
            if(tmpA2==tmpB2){
                return tmpA2;
            }else {
                tmpA2=tmpA2.next;
                tmpB2=tmpB2.next;
            }
        }
        return null;
    }

    public  static  void  main(String args[]) throws Exception{
        ListNode l1 = new ListNode(3,null);
        ListNode l2 = new ListNode(2,null);
        ListNode l3 = new ListNode(3,null);
        l2.next = l3;
        ListNode result = new GetIntersectionNode().getIntersectionNode(l1,l2);
    }
}
