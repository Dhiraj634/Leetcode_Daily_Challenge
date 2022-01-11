package January2022;

import Dhiraj.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    private void  dfs(TreeNode root, int num){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans+=(num<<1)+root.val;
        }
       dfs(root.left,(num<<1)+root.val);
       dfs(root.right,(num<<1)+root.val);
    }
}
