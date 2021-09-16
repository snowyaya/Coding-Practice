// Time O(n) Space O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int k = 0;
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                nums1[k++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}

// Time O(nlogn) Space O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int num : nums1) {
            list1.add(num);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for (int number : nums2) {
            int idx = binarySearch(number, list1);
            if (idx != -1) {
                list1.remove(idx);
                res.add(number);
            }
        }
        
        int i = 0;
        int[] arr = new int[res.size()];
        for (int number : res) {
            arr[i++] = number;
        }
        
        return arr;
    }
    
    public int binarySearch(int num, List<Integer> list1) {
        int left = 0, right = list1.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list1.get(mid) == num) {
                return mid;
            } else if (list1.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
