import java.util.HashMap;

/**
 * Created by liuwenxiu on 2018/2/18.
 */
public class HasCycle {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x,ListNode listNode){
            val = x;
            next = listNode;
        }
    }
    public Boolean hasCycle(ListNode head){
        ListNode now = head;
        HashMap<ListNode,Integer> map =  new HashMap<>();
        while (now !=null){
            if(map.containsKey(now)){
                return true;
            }else {
                map.put(now,1);
            }
            now = now.next;
        }
        return false;
    }
    public static void main(String[] args) throws Exception{
        ListNode l1 = new ListNode(1,null);
        ListNode l2 = new ListNode(2,new ListNode(3,null));
        l1.next = l2;
        l2.next.next = l1;
        Boolean result = new HasCycle().hasCycle(l1);
        System.out.print(result);
    }
}
