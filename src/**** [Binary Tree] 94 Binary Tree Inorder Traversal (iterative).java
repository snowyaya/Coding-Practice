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
