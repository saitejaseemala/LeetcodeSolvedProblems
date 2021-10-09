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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        
        Stack<TreeNode>stack = new Stack<>();
        TreeNode curr = root;
        int result = 0;
        while(curr != null || stack.size() >0){
            while(curr != null) {
            stack.push(curr);
            curr = curr.left;
            }
            curr = stack.pop();
            if(curr.val >= low && curr.val <= high){
                result = result+curr.val;
            }
            curr = curr.right;
        }
        return result;
    }
}