package easy;


/**
 * Created by danny on 2016/10/23.
 */
 class ListNode {

      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
  }

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        ListNode start = merged;
        while (l1!=null || l2!= null){
            if (l1 == null){
                start.next = l2;
                return merged.next;
            }
            if (l2 == null){
                start.next = l1;
                return merged.next;
            }
            if (l1.val < l2.val){
                start.next = l1;
                l1 = l1.next;
                start = start.next;
            }
            else {
                start.next = l2;
                l2 = l2.next;
                start = start.next;
            }
        }
        return merged.next;
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;


        ListNode l11 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        ListNode l33 = new ListNode(6);
        ListNode l44 = new ListNode(7);
        ListNode l55 = new ListNode(8);
        l11.next=l22;
        l22.next=l33;
        l33.next=l44;
        l44.next=l55;

       ListNode result =  mergeTwoLists(l1,l11);
        for(;result.next!=null;)
        {
            System.out.print(result.val);
            result=result.next;
        }

    }
}
