package January2022;

import Dhiraj.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    private int morrisPreorderTraversal(TreeNode root){
        int val = 0;
        int ans = 0;
        TreeNode backDoor;
        while(root != null){
            if(root.left !=null){
                backDoor = root.left;
                int steps = 1;
                while(backDoor.right != null && backDoor.right != root){
                    backDoor=backDoor.right;
                    steps++;
                }
                if(backDoor.right == root){
                    if(backDoor.left == null){
                        ans+=val;
                    }
                    val >>= steps; // Backtracking
                    backDoor.right = null;
                    root = root.right;
                }else{
                    backDoor.right = root;
                    val = (val << 1) + root.val;
                    root = root.left;
                }
            }else{
                val = (val << 1) + root.val;
                if (root.right == null) {
                    ans += val;
                }
                root = root.right;
            }
        }
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