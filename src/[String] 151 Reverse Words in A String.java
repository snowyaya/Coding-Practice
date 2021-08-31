class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for ( int i = 0; i < arr.length; i++) {
            if (arr[i].length() != 0) {
                map.put(i, arr[i]);
            }
            
        }
        
        System.out.println(map);
        String str = "";
        for (int j = arr.length-1; j >= 0; j--) {
            if (map.get(j) != null) {
                str += map.get(j);
            }
            
            if (map.get(j-1) != null) {
                str += " ";
            }
        }
        return str;
    }
}
