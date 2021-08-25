class Solution {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    
    public int climbStairs(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        int result = 0;
        if (n == 1 || n == 2) {
            return n;
        } else {
            result = climbStairs(n-1) + climbStairs(n-2);
        }
        cache.put(n, result);
        return result;
    }
}
