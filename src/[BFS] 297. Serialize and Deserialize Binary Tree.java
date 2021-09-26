// Level Order Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder str = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                str.append("x,");
            } else {
                str.append(curr.val + ",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return str.substring(0, str.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String[] values = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.valueOf(values[i++]));
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (!values[i].equals("x")) {
                curr.left = new TreeNode(Integer.valueOf(values[i]));
                q.add(curr.left);
            }
            i++;
            if (!values[i].equals("x")) {
                curr.right = new TreeNode(Integer.valueOf(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


// Recursion
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "x";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return helperD(q);
    }
    
    public TreeNode helperD(Queue<String> q) {
        String s = q.poll();
        if (s.equals("x")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helperD(q);
        root.right = helperD(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
