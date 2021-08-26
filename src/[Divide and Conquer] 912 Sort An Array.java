class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        
        int pivot = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);
    }
    
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int left_cursor = 0, right_cursor = 0, result_cursor = 0;
        while (left_cursor < left.length && right_cursor < right.length) {
            if (left[left_cursor] < right[right_cursor]) {
                result[result_cursor++] = left[left_cursor++];
            } else {
                result[result_cursor++] = right[right_cursor++];
            }
        }
        // Append what is remaining in the above lists
        while (left_cursor < left.length) {
            result[result_cursor++] = left[left_cursor++];
        }
        while (right_cursor < right.length) {
            result[result_cursor++] = right[right_cursor++];
        }
        return result;
    }
}
