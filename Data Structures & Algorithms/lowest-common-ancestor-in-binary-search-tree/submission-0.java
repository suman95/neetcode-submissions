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
    public boolean find(TreeNode curr, TreeNode p, TreeNode q) {
        if(curr == null) return false;
        if(curr == p || curr == q) return true;
        else {
            boolean left = find(curr.left, p, q);
            boolean right = find(curr.right, p, q);
            return left || right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if (root == p || root == q) {
            return root;
        }
        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);
        if(left && right) return root;
        if (left) return lowestCommonAncestor(root.left,p,q);
        if(right) return  lowestCommonAncestor(root.right,p,q);
        return null;
    }
}
