// Merge sort first the compare
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return 0;
        int maxIdx = 0;
        
        int[] copyNums = Arrays.copyOfRange(nums, 0, nums.length);
        
        int[] sortedNums = mergeSort(copyNums);
        if (sortedNums[sortedNums.length - 1] >= 2*sortedNums[sortedNums.length - 2]) {
            for (int i = 0; i < nums.length; i++) {
                if (sortedNums[sortedNums.length - 1] == nums[i]) {
                    return i;
                }
            }
        }
        return -1;
        
    }
    
    private int[] mergeSort(int[] copyNums) {
        if (copyNums.length <= 1) return copyNums;
        int pivot = copyNums.length / 2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(copyNums, 0, pivot));
        int[] rightArray = mergeSort(Arrays.copyOfRange(copyNums, pivot, copyNums.length));
        
        return merge(leftArray, rightArray);
    }
    
    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];
        int leftPtr = 0, rightPtr = 0, resultPtr = 0;
        
        // Merger two arrays recursively
        while (leftPtr < leftArray.length && rightPtr < rightArray.length) {
            if (leftArray[leftPtr] < rightArray[rightPtr]) {
                result[resultPtr++] = leftArray[leftPtr++];
            } else {
                result[resultPtr++] = rightArray[rightPtr++];
            }
        }
        
        // Append what's left in the given arrays
        while (leftPtr < leftArray.length) {
            result[resultPtr++] = leftArray[leftPtr++];
        }
        while (rightPtr < rightArray.length) {
            result[resultPtr++] = rightArray[rightPtr++];
        }
        return result;
    }
}

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
