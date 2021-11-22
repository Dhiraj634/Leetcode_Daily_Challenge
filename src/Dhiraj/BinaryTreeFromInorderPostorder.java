package Dhiraj;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPostorder {
	Map<Integer,Integer> inorderMap = new HashMap<>();
	int postIndex ;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for(int i=0;i<inorder.length;i++){
			inorderMap.put(inorder[i],i);
		}
		postIndex = postorder.length-1;
		return constructBinaryTree(inorder,postorder,0,inorder.length-1);
	}

	private TreeNode constructBinaryTree(int[] inorder, int[] postorder, int inStart, int inEnd){
		if(inStart < 0 || inEnd >= inorder.length || postIndex < 0 ) return null;
		if(inStart > inEnd  ) return null;
		if(inStart == inEnd){
			postIndex--;
			return new TreeNode(inorder[inStart]);
		}
		int temp = postIndex--;
		TreeNode currNode = new TreeNode(postorder[temp]);
		currNode.right = constructBinaryTree(inorder,postorder,inorderMap.get(postorder[temp])+1,inEnd);
		currNode.left = constructBinaryTree(inorder,postorder,inStart,inorderMap.get(postorder[temp])-1);
		return currNode;

	}
}
