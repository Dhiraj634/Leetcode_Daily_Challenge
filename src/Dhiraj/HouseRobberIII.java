package Dhiraj;

public class HouseRobberIII {

	public int rob(TreeNode root) {
		Pair pair = postOrderTraversal(root);
		return Math.max(pair.taken, pair.notTaken);
	}
	private Pair postOrderTraversal(TreeNode root){
		if(root == null){
			return new Pair(0,0);
		}
		Pair left, right;
		left = postOrderTraversal(root.left);
		right = postOrderTraversal(root.right);
		int tempMax = Math.max(left.notTaken+ right.notTaken,Math.max(left.notTaken+ right.taken,Math.max(left.taken+ right.notTaken, left.taken+ right.taken)));
		Pair ans = new Pair(root.val+ left.notTaken+right.notTaken,tempMax);
		return ans;
	}


	class Pair{
		int taken, notTaken;
		public Pair(int taken, int notTaken){
			this.taken = taken;
			this.notTaken = notTaken;
		}
	}
}
