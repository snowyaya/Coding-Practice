// left -> root -> right
// Iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // left, root, right
        List<Integer> output = new ArrayList<Integer>();
        if (root == null) return output;
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        while (true) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                if (s.isEmpty()) {
                    break;
                } else {
                    root = s.pop();
                    output.add(root.val);
                    root = root.right;
                }
            }
        }
        return output;
    }
}

// Recursive
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // left, root, right
        List<Integer> output = new ArrayList<Integer>();
        helper(root, output);
        return output;
    }
    
    public void helper(TreeNode root, List<Integer> output) {
        if (root == null) return;
        if (root.left != null) {
            helper(root.left, output);
        }
        output.add(root.val);
        if (root.right != null) {
            helper(root.right, output);
        }
        
    }
}
