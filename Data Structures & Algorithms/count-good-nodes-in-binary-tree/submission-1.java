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
    public int goodNodes(TreeNode root) {
        int max = 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, root.val));

        while(!queue.isEmpty()){
            int n = queue.size();

            for (int i = 0; i < n; i++){
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int node_value = pair.getValue();
                if (node.val >= node_value){
                    max++;
                }

                if (node.left != null){
                    queue.add(new Pair(node.left, Math.max(node.val, node_value)));
                }

                if (node.right != null){
                    queue.add(new Pair(node.right, Math.max(node.val, node_value)));
                }
            }
        }
      return max;
      
        
    }
}
