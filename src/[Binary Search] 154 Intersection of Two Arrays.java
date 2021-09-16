// Time O(n) Space O(n)
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

// Time O(nlog(n)) Space O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> commonNums = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            if (binarySearch(nums1[i], nums2)) {
                commonNums.add(nums1[i]);
            }
        }
        
        int[] index = new int[commonNums.size()];
        int i = 0;
        for (int key : commonNums) {
            index[i++] = key;
        }
        return index;
    }
    
    public boolean binarySearch(int num, int[] nums2) {
        int left = 0, right = nums2.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num < nums2[mid]) {
                right = mid - 1;
            } else if (num > nums2[mid]) {
                left = mid + 1;
            } else{
                return true;
            }
        }
        return false;
    }
}
