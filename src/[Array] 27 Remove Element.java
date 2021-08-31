class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            if (nums[left] == val) {
                if (nums[right] == val){
                    right--;
                } else {
                    nums[left] = nums[right];
                    left++;
                    right--;
                }
            } else {
                left++;
            }
        }
        System.out.println(left + " " + right);
        return left;
    }
}
