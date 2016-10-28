package easy;

/**
 * Created by danny on 2016/10/25.
 */
public class SwapNodesInPairs {
    public static class ListNode {
        public int val;
        public String text;
        public ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode current = start;
        while(current.next!=null && current.next.next!=null){
            ListNode first =current.next;
            ListNode second =current.next.next;
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = current.next.next;
        }
        return start.next;
    }

    public static void main(String args[]){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode ll = swapPairs(l1);

        while (ll!=null){
            System.out.print(ll.val);
            ll=ll.next;
        }

    }
}
