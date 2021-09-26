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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = q.size();
            // add nodes in each level to queue
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    levelList.add(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            // if odd level, reverse the nodes
            if (!levelList.isEmpty()) {
                if (level % 2 == 1) {
                    Collections.reverse(levelList); // !!!!!
                }
                output.add(levelList);
            }
            // increment the level
            level++;
        }
        return output;
    }
}
