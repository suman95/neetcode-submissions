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

    int maxDiameter = 0;

    public int traverse(TreeNode node, int level) {
        if(node == null) return level;
        else {
            int left = traverse(node.left, level);
            int right = traverse(node.right, level);
            maxDiameter = Integer.max(maxDiameter, left+right);
            return 1 + Integer.max(left,right);
        }
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        traverse(root,0);
        return maxDiameter;
    }
}
