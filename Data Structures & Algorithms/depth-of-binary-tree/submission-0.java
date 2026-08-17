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

    public int traverse(TreeNode node, int level) {
        if(node == null) return level;
        else {
            int left = traverse(node.left, level+1);
            int right = traverse(node.right, level+1);
            return Integer.max(left,right);
        }
    }

    public int maxDepth(TreeNode root) {
        return traverse(root, 0);
    }
}
