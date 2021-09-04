class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int pivot = 2, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            long num = (long) pivot*pivot;
            if (num > x) {
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }
        return right;
    }
}
