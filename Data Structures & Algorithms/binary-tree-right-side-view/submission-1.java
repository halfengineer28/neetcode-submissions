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
        
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode right = null;
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                right = poll;
                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            ans.add(right.val);
        }
        return ans;
    }
}
