class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 4) return true;
        else if (num > 1 && num < 4) return false;
        long left = 3, right = num; // long type to avoid 2147483647 case
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid*mid == num) {
                return true;
            } else if (mid*mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("END left " + left + " right " + right);
        return false;
    }
}
