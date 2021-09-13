class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
                if (map.get(n) == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
