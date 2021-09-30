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
    List<String> res = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        String str = "";
        if (root == null) return res;
        getPath(root, str);
        return res;
    }
    
    public void getPath(TreeNode root, String str) {
        if (root == null) return; // corner case
        str = str + String.valueOf(root.val) + "->";
        if (root.left == null && root.right == null) { // base case
            res.add(str.substring(0, str.length() - 2)); // take off the last "->"
        }
        getPath(root.left, str);
        getPath(root.right, str);
    }
}
