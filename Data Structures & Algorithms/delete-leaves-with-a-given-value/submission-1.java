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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null){
                if (node.val == target){
                    TreeNode parent = map.get(node);
                    if (parent == null){
                        return null;
                    }

                    if (parent.left == node){
                        parent.left = null;
                    }

                    if (parent.right == node){
                        parent.right = null;
                    }
                }
            }else if (!set.contains(node)){
                set.add(node);
                stack.push(node);
                if (node.left != null){
                    stack.push(node.left);
                    map.put(node.left, node);
                }

                if (node.right != null){
                    stack.push(node.right);
                    map.put(node.right, node);
                }
            }
        }
        return root;
    }
}