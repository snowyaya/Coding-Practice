class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int ptr1 = 0, ptr2 = 0;
        int sum = 0;
        while (ptr2 < nums.length) {
            sum += nums[ptr2];
            if (sum < target) {
                ptr2 += 1;
            } else {
                min = Math.min(min, ptr2 - ptr1 + 1);
                sum = sum - nums[ptr1] -nums[ptr2]; // Update the sum
                ptr1 += 1;
            }
        }
        if (min < Integer.MAX_VALUE) {
            return min;
        } else {
            return 0;
        }
    }
}
