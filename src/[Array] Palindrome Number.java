
// Iterative
class Solution {
    public boolean isPalindrome(int x) {
        String num = Integer.toString(x);
        char[] numArr = num.toCharArray();
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (numArr[left] != numArr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
