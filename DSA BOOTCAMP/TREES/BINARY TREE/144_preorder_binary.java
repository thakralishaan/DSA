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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode curr = root;
        while(curr!=null||!deque.isEmpty()){
           while(curr!=null){
               result.add(curr.val);
               deque.offerFirst(curr);
               curr = curr.left;
           }
            curr = deque.removeFirst();
            curr = curr.right;
        }
        return result;
    }
}