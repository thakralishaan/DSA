/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    
    private int height(TreeNode root){
        
        if(root== null)
            return 0;
        
        int leftAns= 1+ height(root.left);
        int rightAns= 1+ height(root.right);
        
        return Math.max(leftAns, rightAns);   // T.C 0(n)  S.C we use 0(1) space but the depth will take 0(h) or 0(n), where n is number of nodes
    }
}