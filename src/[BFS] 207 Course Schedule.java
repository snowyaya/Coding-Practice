class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        HashSet<Integer> toBeVisited = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            preMap.putIfAbsent(course, new ArrayList<>()); // map.putIfAbsent!!!
            preMap.get(course).add(preReq);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(toBeVisited, preMap, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(HashSet<Integer> toBeVisited, 
                       HashMap<Integer, List<Integer>> preMap, int course) {
        if (toBeVisited.contains(course)) {
            return false;
        }
        if (preMap.get(course) == null || preMap.get(course).size() == 0) {
            return true;
        }
        toBeVisited.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(toBeVisited, preMap, pre)) {
                return false;
            }
        }
        toBeVisited.remove(course);
        preMap.replace(course, new ArrayList<>());
        return true;
    }
}
