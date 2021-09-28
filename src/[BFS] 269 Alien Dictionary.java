// BFS
// Topological Sort

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        String res = "";
        if (words == null || words.length == 0) return res;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                indegrees.put(c, 0); // why not +1?
            }
        }
        
        for (int i = 0; i < words.length-1; i++) {
            String curr = words[i];
            String next = words[i+1];
            // In a valid alphabet, prefixes are always first
            if (curr.length() > next.length() && curr.startsWith(next)) {
                return "";
            }
            int length = Math.min(curr.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) {
                        set = map.get(c1);
                    }
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        indegrees.put(c2, indegrees.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        for (char c : indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                q.add(c);
            }
        }
        
        while (!q.isEmpty()) {
            char c = q.remove();
            res += c;
            if (map.containsKey(c)) {
                for (char c2 : map.get(c)) {
                    indegrees.put(c2, indegrees.get(c2) - 1);
                    if (indegrees.get(c2) == 0) {
                        q.add(c2);
                    }
                }
            }
        }
        
        if (res.length() != indegrees.size()) return "";
        return res;
    }
}
