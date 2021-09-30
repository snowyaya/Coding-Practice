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
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        
        List<Integer> list = new ArrayList<>();
        getPath(root, targetSum, list);
        return res;
    }
    
    public void getPath(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) return;
        
        targetSum -= root.val;
        list.add(root.val);
        
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<Integer>(list));
        }
        getPath(root.left, targetSum, list);
        getPath(root.right, targetSum, list);
        list.remove(list.size() - 1); /**
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
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        
        List<Integer> list = new ArrayList<>();
        getPath(root, targetSum, list);
        return res;
    }
    
    public void getPath(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) return;
        
        targetSum -= root.val;
        list.add(root.val);
        
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<Integer>(list));
        }
        getPath(root.left, targetSum, list);
        getPath(root.right, targetSum, list);
        list.remove(list.size() - 1); // remove the last element if the targetSum != 0
    }
 }
    }
 }
