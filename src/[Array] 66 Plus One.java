class Solution {
    public int[] plusOne(int[] digits) {
        // Edge case
        if (digits == null) return null;
        
        int n = digits.length;
        for(int i = n-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // For the whole array of 9s, like 99999
        int[] newNumber = new int[n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
