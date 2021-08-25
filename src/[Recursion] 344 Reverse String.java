// Iteratioin
class Solution {
    public void reverseString(char[] s) {        
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        
    }
}

// Recursion
class Solution {
    public void reverseString(char[] s) {        
        helper(s, 0, s.length - 1);
    }
    public void helper(char[] s, int left, int right){
        if (left >= right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        helper(s, left + 1, right - 1);
    }
}
