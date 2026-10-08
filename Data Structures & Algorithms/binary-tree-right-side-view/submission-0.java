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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode curr = null;
            for(int i = 0 ; i < size; i++) {
                curr = q.poll();
                if(curr.left!= null) q.offer(curr.left);
                if(curr.right!= null) q.offer(curr.right);
            }
            if(curr != null)
                res.add(curr.val);
        }
        return res;
    }
}
