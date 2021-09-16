class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> commonNums = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                commonNums.add(nums2[i]);
            }
        }
        
        int[] index = new int[commonNums.size()];
        int i = 0;
        for (int key : commonNums) {
            index[i++] = key;
        }
        return index;
        
    }
}
