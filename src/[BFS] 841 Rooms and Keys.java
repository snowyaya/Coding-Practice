// BFS

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null) return false;
        
        // map is not needed because there is no directed or undirected edges
        Set<Integer> visited = new HashSet<>(); // store the explored room
        Queue<Integer> q = new LinkedList<>(); // store the to be visited room
        q.offer(0); // start from visiting room 0
        visited.add(0); // room 0 already visited
        
        // visite all rooms by the keys from room 0
        while (!q.isEmpty()) {
            int key = q.poll();
            for (int k : rooms.get(key)) {
                if (visited.contains(k)) continue;
                visited.add(k);
                q.offer(k);
            }
        }
        System.out.println(q);
        System.out.println(visited);
        
        return visited.size() == rooms.size();
    }
}
