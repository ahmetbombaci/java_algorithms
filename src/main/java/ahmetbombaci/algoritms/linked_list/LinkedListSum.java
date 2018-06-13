package ahmetbombaci.algoritms.linked_list;

public class LinkedListSum {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode result = null;
        ListNode tail = null;
        int num1, num2, value;
        
        while(l1!=null || l2!=null) {
            num1 = 0;
            num2 = 0;
            if(l1!=null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            
            value = (num1 + num2 + carryOver) % 10;
            ListNode current = new ListNode(value);
            
            if(result == null) {
                result = current;
                tail = current;
            }
            else {
                tail.next = current;
                tail = current;
            }
            
            carryOver = (num1 + num2 + carryOver) / 10;
        }
        
        if(carryOver>0) {
            ListNode current = new ListNode(carryOver);
            tail.next = current;         
        }
        
        return result;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
