package ahmetbombaci.algoritms.binary_search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBSTValidator {
	
	private BSTValidator bstValidator = new BSTValidator();

	@Test
	public void testSimpleSuccess() {
		BinaryTreeNode root = new BinaryTreeNode(4);
		root.addLeft(3);
		root.addRight(5);
		
		assertEquals(true, bstValidator.isValid(root));
	}

	@Test
	public void testSimpleFail() {
		BinaryTreeNode root = new BinaryTreeNode(4);
		root.addLeft(6);
		root.addRight(5);
		
		assertEquals(false, bstValidator.isValid(root));
	}
	

	@Test
	public void testSingle() {
		BinaryTreeNode root = new BinaryTreeNode(4);
		
		assertEquals(true, bstValidator.isValid(root));
	}
	
}
