class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) return s;
        String newString = "";
        String[] strArray = s.split("\\s+");
        
        for (int i = 0; i < strArray.length; i++) {
            String newStr = reverse(strArray[i]);
            newString += newStr;
            if (i != strArray.length - 1) {
                newString += " ";
            }
        }
        return newString;
    } 
    
    public String reverse(String str) {
        if (str == null || str.length() <= 1) return str;
        char[] charArray = str.toCharArray();
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        
        String newStr = "";
        for (char c : charArray) {
            newStr += c;
        }
        return newStr;
    }
}
