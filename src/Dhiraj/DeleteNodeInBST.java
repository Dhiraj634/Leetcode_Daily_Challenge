package Dhiraj;

public class DeleteNodeInBST {
	/**
	 * If child node then just put it's reference as null
	 * if not child Node find min element in rightSubTree and replace the current it with it
	 * */
	int minElement = Integer.MIN_VALUE;
	public TreeNode deleteNode(TreeNode root, int key) {
		return searchForElement(root, key);
	}
	private TreeNode searchForElement(TreeNode node, int key){
		if(node == null){
			return null;
		}
		if(key == node.val){
			node.right = minElementOnRight(node.right);
			if(minElement == Integer.MIN_VALUE){
				return node.left;
			}else{
				node.val = minElement;
				return node;
			}

		}
		if(key > node.val){
			node.right = searchForElement(node.right,key);
		}else{
			node.left = searchForElement(node.left,key);
		}
		return node;
	}
	private TreeNode minElementOnRight(TreeNode node){
		if(node ==null)return null;
		if(node.left == null){
			minElement = node.val;
			if(node.right ==null)return null;
			return node.right;
		}
		else{
			node.left = minElementOnRight(node.left);
			return node;
		}
	}
}
