class Solution {
    public void rotate(int[] nums, int k) {
        int steps = k % nums.length;
        int[] numsCopy = Arrays.copyOfRange(nums, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (i < steps) {
                System.out.println(i);
                nums[i] = numsCopy[i + nums.length - steps];
            } else {
                nums[i] = numsCopy[i - steps];
            }
        }
    }
}
