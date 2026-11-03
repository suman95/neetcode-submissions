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
    Integer globalMax = Integer.MIN_VALUE;

    int dfs(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) {
            globalMax = Math.max(globalMax, node.val);
            return  node.val;
        } else {
            int leftPathMax = Math.max(dfs(node.left),0);
            int rightPathMax = Math.max(dfs(node.right),0);
            globalMax = Math.max(globalMax, node.val + leftPathMax + rightPathMax);
            return node.val + Math.max(leftPathMax, rightPathMax);
        }
    }

    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        dfs(root);
        return globalMax;
    }
}
