// Merge sort first the compare


// Iteration
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        int max = 0, secondMax = 0;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= secondMax && nums[i] != max) {
                secondMax = nums[i];
                if (secondMax * 2 > max) {
                    return -1;
                }
            }
        }
        return maxIdx;
        
    }
}
