class Solution {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // Sort the array
        Arrays.sort(nums);
        // Iterate over
        int ptr = 0;
        int max = 0;
        while (ptr < nums.length-1) {
            max += Math.min(nums[ptr], nums[ptr+1]);
            ptr += 2;
        }
        return max;
    }
}
