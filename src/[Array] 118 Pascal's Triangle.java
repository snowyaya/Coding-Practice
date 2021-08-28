class Solution {
    
    HashMap<Integer, List<Integer>> cache = new HashMap<Integer, List<Integer>>();
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        
        // Edge check
        if (numRows < 0) return output;
        List<Integer>row = getRow(numRows - 1);
        System.out.println(cache);
        for (int i = 0; i < numRows; i++) {
            output.add(cache.get(i));
        }
        return output;
    }
    
    private List<Integer> getRow(int numRows) {
        if (cache.containsKey(numRows)) {
            return cache.get(numRows);
        }
        
        if (numRows == 0) {
            cache.put(0, Arrays.asList(1));
            return Arrays.asList(1);
        }
        
        List<Integer> prevRow = getRow(numRows - 1);
        List<Integer> currRow = new ArrayList<Integer>();
        
        for (int i = 0; i < prevRow.size(); i++) {
            if (i == 0) currRow.add(1);
            if (i > 0) currRow.add(prevRow.get(i) + prevRow.get(i-1));
            if (i == prevRow.size() - 1) currRow.add(1);
        }
        cache.put(numRows, currRow);
        return currRow;
    }
}
