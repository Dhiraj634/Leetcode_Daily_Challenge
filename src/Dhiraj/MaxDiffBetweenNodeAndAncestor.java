package Dhiraj;

public class MaxDiffBetweenNodeAndAncestor {
    int ans = -1;
    public int maxAncestorDiff(TreeNode root) {
        getMaxMin(root);
        return ans;
    }
    private int[] getMaxMin(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null){
            return new int[]{root.val, root.val};
        }
        int max=-1,min=Integer.MAX_VALUE;

        int[] right =getMaxMin(root.right);
        int[] left =getMaxMin(root.left);
        if(right != null){
            max = right[1];
            min = right[0];
        }
        if(left != null){
            max = Math.max(max,left[1]);
            min = Math.min(min,left[0]);
        }
        int tempMax = Math.max(Math.abs(root.val - min),Math.abs(root.val-max));
        ans = Math.max(ans,tempMax);
        return new int[]{Math.min(root.val, min), Math.max(max, root.val)};
    }
}
