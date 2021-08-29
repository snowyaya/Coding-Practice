class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> output = new HashSet<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(output);
        }
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
                continue;
            }
            int low = i+1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    output.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                    // low++;
                    // high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return new ArrayList<>(output);
    }  
}
