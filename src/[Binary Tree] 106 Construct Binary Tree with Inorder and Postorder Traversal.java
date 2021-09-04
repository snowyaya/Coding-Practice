class Solution {
    
    private int idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        idx = postorder.length-1;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(inorder, postorder, 0, idx, map);
        return root;
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int start, int end, HashMap<Integer, Integer> map) {
        if (start>end) return null;
        TreeNode node = new TreeNode(postorder[idx--]);
        if (start==end) return node;
        
        int index = map.get(node.val);
        node.right = build(inorder, postorder, index+1, end, map);
        node.left = build(inorder, postorder, start, index-1, map);
        return node;
    }
}
