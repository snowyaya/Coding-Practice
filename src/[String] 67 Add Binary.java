// Explanation https://leetcode.com/problems/add-binary/discuss/190723/5ms-Java-solution-with-explanation-of-code-and-binary-adding.
class Solution {
    public String addBinary(String a, String b) {
        // As another user pointed out, iterating across char arrays is faster than using
        // charAt(); So split into them and iterate with a single pointer.
        char[] aArray = a.toCharArray();
        int aLen = aArray.length;

        char[] bArray = b.toCharArray();
        int bLen = bArray.length;

        int ptr = 0;

        int carry=0;
        int aVal=0;
        int bVal=0;
        String strToReturn = "";

        while(ptr < aLen || ptr < bLen) {
            aVal=0; bVal=0; // Reset values after every pointer iteration.
            if(ptr < aLen) {
                 aVal = (aArray[aLen-1 -ptr] == '1') ? 1 : 0; // Converts from char to integer
            }  
            if(ptr <bLen) {
                bVal = (bArray[bLen-1 -ptr] == '1') ? 1 : 0;
            }
            int finalVal = aVal +bVal + carry; // total after adding carry.
            if(finalVal > 1) {
                carry = finalVal - 1;
                if(carry > 1) {
                    finalVal = 1; carry = 1; 
                } else {
                    finalVal = 0;
                }
            } else {
                carry = 0; // If either 0 or 1 after adding carry, just reset carry.
            }
            strToReturn = finalVal + "" + strToReturn; // Add to front of string.
            ptr++;
        }
        if(carry > 0) strToReturn = "1" + strToReturn; // If any leftover carry at the end, just append a “1” to the start.
        return strToReturn;
    }
}
