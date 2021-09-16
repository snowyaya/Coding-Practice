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
    public int closestValue(TreeNode root, double target) {
        double closest = Double.POSITIVE_INFINITY;
        int return_value = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (closest > Math.abs(curr.val - target)) {
                closest = Math.abs(curr.val - target);
                return_value = curr.val;
            }
            
            if (curr.val > target) {
                curr = curr.left;
            } else if (curr.val < target) {
                curr = curr.right;
            } else {
                break;
            }
        }
        return return_value;
    }
}
