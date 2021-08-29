class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        
        int lenOfNeedle = needle.length();
        int i = 0;
        while (i+lenOfNeedle <= haystack.length()) {
            String subStr = haystack.substring(i, i+lenOfNeedle);
            if (subStr.equals(needle)) {
                return i;
            } 
            i++;
        }
        return -1;
    }
}
