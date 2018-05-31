package ahmetbombaci.algoritms.binary_search;

public class BinaryTreeNode {

	private int value;
	
	private BinaryTreeNode right;
	
	private BinaryTreeNode left;
	
	public BinaryTreeNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void addRight(int value) {
		this.right = new  BinaryTreeNode(value);
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void addLeft(int value) {
		this.left = new  BinaryTreeNode(value);;
	}
	
}
