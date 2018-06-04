package ahmetbombaci.algoritms.linked_list;

public class LinkedListNode {
	public int data;
	public LinkedListNode next;
	
	public LinkedListNode(int _data)
	{
		this.data = _data;
	}
	
	public static void printList(LinkedListNode head)
	{
		LinkedListNode node = head;
		
		while(node != null)
		{
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		
		System.out.println("null");
	}
	
	public static int size(LinkedListNode head)
	{
		int count = 0;

		LinkedListNode node = head;
		
		while(node != null) {
			count++;
			node = node.next;
		}
		
		return count;
	}
}
