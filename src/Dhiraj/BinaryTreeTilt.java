package Dhiraj;

public class BinaryTreeTilt {
	private int ans = 0;
	public int findTilt(TreeNode root) {
		this.getTheAnswer(root);
		return ans;
	}
	private int getTheAnswer(TreeNode root){
		if(root == null)
			return 0;
		int leftSum = getTheAnswer(root.left);
		int rightSum = getTheAnswer(root.right);
		this.ans += Math.abs(leftSum - rightSum);
		return leftSum + rightSum + root.val;
	}
}
