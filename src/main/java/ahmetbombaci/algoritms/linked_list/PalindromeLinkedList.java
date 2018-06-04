package ahmetbombaci.algoritms.linked_list;

public class PalindromeLinkedList {
	
	public class PalindromeRecursionResult {
		boolean result;
		LinkedListNode next;
		
		public PalindromeRecursionResult(boolean _result, LinkedListNode _next) {
			this.result = _result;
			this.next = _next;
		}
	}
	
	public boolean checkPalindromeRecursive(LinkedListNode node) {
		int length = LinkedListNode.size(node);
		return checkPalindromeRecursive(node, length).result;
	}
	
	

	private PalindromeRecursionResult checkPalindromeRecursive(LinkedListNode node, int length) {
		if(length==1) {
			return new PalindromeRecursionResult(true, node.next);
		}
		else if(length==2) {
			return new PalindromeRecursionResult((node.data == node.next.data), node.next.next);
		}
		else {
			PalindromeRecursionResult result = checkPalindromeRecursive(node.next, length-2);
			return new PalindromeRecursionResult((node.data == result.next.data), result.next.next);
		}
	}



	public static boolean checkPalindrome(LinkedListNode node) {
		LinkedListNode head = node;
		
		LinkedListNode reverseHead = reverseList(node);
		
		while(head!=null) {
			if(head.data!=reverseHead.data)
				return false;
			
			head = head.next;
			reverseHead = reverseHead.next;
		}
		return true;
	}
	
	private static LinkedListNode reverseList(LinkedListNode node) {
		LinkedListNode head = node;
		LinkedListNode reverseHead = null;
		
		while(head!=null) { 
			LinkedListNode newNode = new LinkedListNode(head.data);
			newNode.next = reverseHead;
			reverseHead = newNode;
			
			head = head.next;
		}
		
		return reverseHead;
	}

	public static void main(String[] args) {

		LinkedListNode head = new LinkedListNode(3);
		LinkedListNode next = head;

		LinkedListNode node = new LinkedListNode(5);
		next.next = node;
		next = node;

		node = new LinkedListNode(5);
		next.next = node;
		next = node;

		node = new LinkedListNode(3);
		next.next = node;
		next = node;

		node = new LinkedListNode(5);
		next.next = node;
		next = node;

		node = new LinkedListNode(5);
		next.next = node;
		next = node;

		node = new LinkedListNode(3);
		next.next = node;

		LinkedListNode.printList(head);
		
		if(checkPalindrome(head)){
			System.out.println("Yes, it is a palindrome");
		}
		else {
			System.out.println("Maybe, it is not a palindrome...");
		}		
		
		PalindromeLinkedList executer = new PalindromeLinkedList();
		

		if(executer.checkPalindromeRecursive(head)){
			System.out.println("Yes, it is a palindrome");
		}
		else {
			System.out.println("Maybe, it is not a palindrome...");
		}		
		
		
	}
}
