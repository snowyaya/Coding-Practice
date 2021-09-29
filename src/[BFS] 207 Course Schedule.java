// BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        HashMap<Integer, Integer> indegrees = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = numCourses; // number of successfully visited courses
        
        // initialize preMap and indegrees
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            preMap.putIfAbsent(preReq, new ArrayList<Integer>());
            preMap.get(preReq).add(course);
            indegrees.putIfAbsent(course, 0);
            indegrees.replace(course, indegrees.get(course) + 1);
        }
        
        // add sources to queue
        for (int i = 0; i < numCourses; i++) {
            if (indegrees.get(i) == null || indegrees.get(i) == 0) {
                q.offer(i);
            }
        }
        
        // bdf visit each course
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nei : preMap.getOrDefault(curr, new ArrayList<Integer>())) {
                indegrees.replace(nei, indegrees.get(nei) - 1);
                if (indegrees.get(nei) == 0) {
                    q.offer(nei);
                } 
            }
            count--;
        }
        return count == 0;
    }
}


// DFS
class Solution {
    // We will use a hash map to store each course and its prerequisites. 
    // We will use a hashset to store each to-be-visited course, remove it after the course and its
    // prerequisites get fully visited. 
    // To get this done, we will use DFS to fully visit every course.
    // The base case is when the course is already in the to-be-visited set, dfs returns false,
    // because that means there's a loop in the graph and a course cannot be the prerequisite for itself.
    // If a course's prerequisites list is empty, meaning completing this course doesn't require completing
    // any other course, so this course can be completed and dfs should return true.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Map each course to preMap, course is the key, value is an empty list
        // the value, empty list, will store the prerequisites of the course
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        
        // A visit set to store all courses along the current DFS path
        Set<Integer> visit = new HashSet<>();
        
        // Put all courses with its prerequisites to the map
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            preMap.putIfAbsent(course, new ArrayList<>()); // *map.putIfAbsent() is very useful
            preMap.get(course).add(preReq);
        }
        
        // Check all courses in the number of courses just in case the graph is not fully connected
        // so we can be sure every course in the graph gets checked.
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visit, preMap, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(Set<Integer> visit, HashMap<Integer, List<Integer>> preMap, int course) {
        
        // If the course is in the visit course set already, meaning theres is loop, return false.
        if (visit.contains(course)) {
            return false;
        }
        
        // If the value of the course in preMap is empty, meaning the course can be finished, return true.
        if (preMap.get(course) == null || preMap.get(course).size() == 0) {
            return true;
        }
        
        // If the course is not in the visit set, add it to the set.
        visit.add(course);
        
        // Iterate over every prerequisite course in preMap with dfs
        // if dfs() returns false, meaning the prerequisite cannot be finished,
        // so we can return false for this prerequisite
        for (int pre : preMap.get(course)) {
            if (!dfs(visit, preMap, pre)) {
                return false;
            }
        }
        
        // Now we finished visiting the course, remove it from the visit set 
        // so we won't have to visit it again.
        visit.remove(course);
        
        // Set the course's prerequisite list to an empty list so we won't have to revisit the prerequisites.
        preMap.replace(course, new ArrayList<>());
        
        // dfs now returns true
        return true;
        
    }
}
