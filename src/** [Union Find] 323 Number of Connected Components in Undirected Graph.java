class Solution {
    public int countComponents(int n, int[][] edges) {
        // initialize from 0 to n-1
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = Find(edges[i][0], nums);
            int y = Find(edges[i][1], nums);
            // if two vertices happen to be in the same set
            // then no need to union, continue
            if (x == y) continue;
            // if both x and y are separate, union them
            nums[x] = y;
        }
            
        // find the number of root, since hashset will keep unique values
        // avoid storing repeating root values
        Set<Integer> count = new HashSet<>();
        for(int i = 0; i < n; i++){
            count.add(Find(i, nums));
        }
        
        return count.size();
    }
    
    public int Find(int x, int nums[]) {
        while (nums[x] != x) {
            nums[x] = nums[nums[x]];
            x = nums[x];
        }
        return x;
    }
}
