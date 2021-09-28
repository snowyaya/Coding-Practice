// BFS
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     List<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList();
        Map<DirectedGraphNode, Integer> indegree = new HashMap();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode nei : node.neighbors) {
                indegree.putIfAbsent(node, 0); // note: need to add node itself to start
                indegree.put(nei, indegree.getOrDefault(nei, 0) + 1);
            }
        }

        Queue<DirectedGraphNode> q = new LinkedList();
        for(DirectedGraphNode key : indegree.keySet()) {
            if(indegree.get(key) == 0) q.add(key);
        }

        while(q.size() > 0) {
            DirectedGraphNode node = q.poll();
            res.add(node);
            for(DirectedGraphNode nei : node.neighbors) {
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0) q.add(nei);
            }
        }
        return res;
    }
}
