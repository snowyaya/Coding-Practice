class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<Integer>();
            int level = q.size();
            for (int i = 0; i < level; i++) {
                root = q.remove();
                levelList.add(root.val);
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }
            output.add(levelList);
        }
        return output;
    }
}
