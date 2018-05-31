package ahmetbombaci.algoritms.binary_search;

public class BSTValidator {
		
	public boolean isValid(BinaryTreeNode root) {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	private boolean isValid(BinaryTreeNode node, int minValue, int maxValue) {
		
		if(node.getValue()>minValue || node.getValue()<maxValue)
			return false;

		if(node.getLeft() != null) {
			if(node.getLeft().getValue() >= node.getValue()) {
				return false;
			}
			
			if(!isValid(node.getLeft(), minValue, node.getValue())) {
				return false;
			}
		}

		if(node.getRight() != null) {
			if(node.getRight().getValue() < node.getValue()) {
				return false;
			}
			
			if(!isValid(node.getRight(), node.getValue(), maxValue)) {
				return false;
			}
		}
				
		return true;
	}

}
