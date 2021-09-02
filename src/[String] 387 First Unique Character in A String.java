class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
                System.out.println(map);
            } else {
                map.replace(array[i], map.get(array[i]) + 1);
            }
        }
        // System.out.println(map);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                char cha = entry.getKey();
                int index = s.indexOf(cha);
                return index;
            }
        }
        return -1;
    }
}
