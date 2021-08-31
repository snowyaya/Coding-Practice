class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        ArrayList<Integer> maxOne = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxOne.add(max);
                max = 0;
            } else if (nums[i] == 1) {
                System.out.println("i " + i);
                max += 1;
                maxOne.add(max);
            }
            
        }
        return Collections.max(maxOne);
    }
}
