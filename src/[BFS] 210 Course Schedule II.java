class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {        
        // get indegrees
        HashMap<Integer, Integer> indegrees = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees.putIfAbsent(prerequisites[i][0], 0);
            indegrees.put(prerequisites[i][0], indegrees.get(prerequisites[i][0]) + 1);
        }
        System.out.println("indegrees " + indegrees);
        
        // get preMap, can tell us neighbors
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            preMap.putIfAbsent(preReq, new ArrayList<>());
            preMap.get(preReq).add(course);
            
        }
        System.out.println("preMap " + preMap);
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees.get(i) == null || indegrees.get(i) == 0) {
                q.add(i);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                res.add(curr);
                for (int nei : preMap.getOrDefault(curr, new ArrayList<Integer>())) {
                    indegrees.replace(nei, indegrees.get(nei) - 1);
                    if (indegrees.get(nei) == 0) {
                        q.add(nei);
                    }
                }
            } 
        }
        System.out.println("res " + res);
        
        int[] arr = new int[res.size()];
        if (res.size() != numCourses) {
            return new int[0];
        }
        int a = 0;
        for (int i = 0; i < res.size(); i++) {
            arr[a++] = res.get(i);
        }
        return arr;
    }
    
}
