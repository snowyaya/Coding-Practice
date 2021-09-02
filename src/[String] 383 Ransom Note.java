class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        char[] arrOfM = magazine.toCharArray();
        char[] arrOfR = ransomNote.toCharArray();
        HashMap<Character, Integer> mag = new HashMap<Character, Integer>();
        for (int i = 0; i < arrOfM.length; i++) {
            if (!mag.containsKey(arrOfM[i])) {
                mag.put(arrOfM[i], 1);
            } else {
                mag.replace(arrOfM[i], mag.get(arrOfM[i]) + 1);
            }
        }
                
        for (int i = 0; i < arrOfR.length; i++) {
            if (mag.containsKey(arrOfR[i])) {
                if (mag.get(arrOfR[i]) < 1) {
                    return false;
                } else {
                    mag.replace(arrOfR[i], mag.get(arrOfR[i]) - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
