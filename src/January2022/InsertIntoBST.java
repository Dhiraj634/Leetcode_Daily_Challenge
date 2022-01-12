package January2022;

import Dhiraj.TreeNode;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val){
        return this.insertIntoBSTRecursive(root, val);
//        return this.insertIntoBSTIterative(root, val);
    }
    private TreeNode insertIntoBSTRecursive(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
         if(val < root.val){
             root.left = insertIntoBST(root.left, val);
         }else{
             root.right = insertIntoBST(root.right, val);
         }

        return root;
    }

    private TreeNode insertIntoBSTIterative(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        TreeNode prevNode= root, head = root;
        while(root!=null){
            prevNode = root;
            root = val < root.val ? root.left : root.right;
        }
        if(val < prevNode.val)
            prevNode.left = new TreeNode(val);
        else
            prevNode.right = new TreeNode(val);
        return head;
    }
}
