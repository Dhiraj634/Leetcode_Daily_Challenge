package January2022;

import Dhiraj.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBST {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> firstBst = new ArrayList<>();
        List<Integer> secondBst = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        traverse(firstBst, root1);
        traverse(secondBst, root2);
        int n = firstBst.size(), m = secondBst.size();
        int i = 0, j=0;
        while(i < n && j < m){
            if(firstBst.get(i) <= secondBst.get(j)){
                ans.add(firstBst.get(i++));
            }else{
                ans.add(secondBst.get(j++));
            }
        }
        while(i < n){
            ans.add(firstBst.get(i++));
        }
        while(j<m){
            ans.add(secondBst.get(j++));
        }
        return ans;
    }
    void traverse(List<Integer> ans, TreeNode root){
        if(root == null) return;
        traverse(ans, root.left);
        ans.add(root.val);
        traverse(ans, root.right);
    }
}
