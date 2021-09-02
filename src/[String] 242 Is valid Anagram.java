class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(arrS[i])) {
                map.put(arrS[i], 1);
            } else {
                map.replace(arrS[i], map.get(arrS[i]) + 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(arrT[i])) {
                map.replace(arrT[i], map.get(arrT[i]) - 1);
                if (map.get(arrT[i]) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
