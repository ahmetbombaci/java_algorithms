package ahmetbombaci.algoritms.linked_list;

public class PartitionLinkedList {
	
	
	public static LinkedListNode doPartition(LinkedListNode node, int value)
	{
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		
		while(node != null) {
			LinkedListNode next = node.next;
			
			if(node.data < value) {
				node.next = head;
				head = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			
			node = next;
		}
		
		tail.next = null;

		return head;
	}
		
	
	public static void main(String[] args)
	{
		LinkedListNode head = new LinkedListNode(3);
		LinkedListNode next = head;

		LinkedListNode node = new LinkedListNode(5);
		next.next = node;
		next = node;

		node = new LinkedListNode(8);
		next.next = node;
		next = node;

		node = new LinkedListNode(5);
		next.next = node;
		next = node;

		node = new LinkedListNode(10);
		next.next = node;
		next = node;

		node = new LinkedListNode(2);
		next.next = node;
		next = node;

		node = new LinkedListNode(1);
		next.next = node;

		LinkedListNode.printList(head);
		
		node = doPartition(head, 5);
		
		LinkedListNode.printList(node);
	}

}
