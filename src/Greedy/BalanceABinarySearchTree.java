package Greedy;

import Dhiraj.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inOrder = new ArrayList<>();
        inOrderTraversal(inOrder, root);
        return createBST(inOrder, 0, inOrder.size()-1);
    }
    private void inOrderTraversal(List<TreeNode> inOrder, TreeNode root){
        if(root == null) return;
        inOrderTraversal(inOrder,root.left);
        inOrder.add(root);
        inOrderTraversal(inOrder, root.right);
    }
    private TreeNode createBST(List<TreeNode> inOrder, int start, int end){
        if(start > end) return null;
        if(start == end){
            return new TreeNode(inOrder.get(start).val);
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(inOrder.get(mid).val);
        root.left = createBST(inOrder, start,mid-1);
        root.right = createBST(inOrder, mid+1, end);
        return root;
    }
}
