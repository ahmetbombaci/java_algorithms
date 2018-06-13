package ahmetbombaci.algoritms.linked_list;

public class MergeKLinkedList {

	// Merge k sorted linked lists and return it as one sorted list. 
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = null;
        int i;
        
        for(i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                head = lists[i];
                break;
            }
        }
        
        for(int j=i+1; j<lists.length; j++) {
            ListNode c1Prev = null;
            ListNode c1 = head;
            ListNode c2 = lists[j];
            
            while(c1!=null && c2!=null) {
                if(c1.val <= c2.val) {
                    c1Prev = c1;
                    c1 = c1.next;
                }
                else {
                    if(c1Prev == null) {
                        head = c2;
                        c2 = c2.next;
                        head.next = c1;
                        c1Prev = head;
                    }
                    else {
                        c1Prev.next = c2;
                        c2 = c2.next;
                        c1Prev.next.next = c1;
                        c1Prev = c1Prev.next;
                    }
                }
            }
            
            if(c1 == null) {
                c1Prev.next = c2;
            }
        }
        
        return head;
        
    }
}
