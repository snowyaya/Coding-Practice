class Solution {
    public boolean validTree(int n, int[][] edges) {
        // acyclic would return false
        if (n < 1) return false;
        
        // create hashmap to store info of edges
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            map.get(start).add(end); // do both because graph is undirected
            map.get(end).add(start);
        }
        System.out.println(map);
        
        // bfs starts with node in label "0"
        Set<Integer> set = new HashSet<>(); // store explored node
        Queue<Integer> q = new LinkedList<>(); // store nodes need to be explored
        q.offer(0);
        while(!q.isEmpty()) {
            int curr = q.poll();
            // if set already contains curr, then the graph has cycle
            // hence return false
            if (set.contains(curr)) {
                return false;
            }
            
            // we should remove the edge: node -> top
            // after adding a node into set to avoid duplicate
            // since we already consider top -> node
            for (int neighbor : map.get(curr)) {
                q.offer(neighbor);
                map.get(neighbor).remove(curr);
            }
            set.add(curr); // curr is explored, add to set
        }
        return set.size() == n;
    }
}
