class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        // Sort the strs array by string length
        Arrays.sort(strs);
        
        StringBuilder prefix = new StringBuilder();
        
        if (strs != null && strs.length > 1) {
            char[] start = strs[0].toCharArray();
            char[] last = strs[strs.length-1].toCharArray();
            for (int i = 0; i < start.length; i++) {
                if (last.length > i && start[i] == last[i]) {
                    prefix.append(last[i]);
                } else {
                    return prefix.toString();
                }
            }
        }
        
        return prefix.toString();
    }
}
