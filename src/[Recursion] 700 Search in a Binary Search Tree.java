// Recursion
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // root -> left -> right
        if (root == null || root.val == val) return root;
        
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        } 
    }
}

// Iteration
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // root -> left -> right
        if (root == null || root.val == val) return root;
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
