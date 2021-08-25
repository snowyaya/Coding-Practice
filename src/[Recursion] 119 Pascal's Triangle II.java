public List<Integer> getRow(int rowIndex) {
    if (rowIndex == 0) return Array.asList(1);
    if (rowIndex == 1) return Array.asList(1, 1);
  
    List<Integer> prevRow = getRow(rowIndex - 1);
    List<Integer> currRow = new ArrayList<Integer>();
  
    for (int i = 0; i < prevRow.size(); i++) {
      currRow.add(prevRow.get(i) + prevRow.get(i-1));
    }
  
    return currRow;
}
