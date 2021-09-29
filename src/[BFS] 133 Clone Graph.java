/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.val);
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(newNode.val, newNode);
        Queue<Node> q = new LinkedList<>(); // to store original nodes need to be visited
        q.add(node); // add first original node to queue
        while (!q.isEmpty()) { // if more nodes need to be visited
            Node curr = q.poll(); // search for first node in the queue
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor.val)) { // add to map and queue if this node hasn't been visited
                    map.put(neighbor.val, new Node(neighbor.val)); 
                    q.offer(neighbor);
                }
                map.get(curr.val).neighbors.add(map.get(neighbor.val)); // add neighbor to newly created nodes
            }
        }
        return newNode;
    }
}
