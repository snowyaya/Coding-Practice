class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        
        int rowLow = 0;
        int rowHigh = matrix.length - 1;
        int colLow = 0;
        int colHigh = matrix[0].length - 1;
        return searchSubArray(matrix, rowLow, rowHigh, colLow, colHigh, target);
    }
    
    private boolean searchSubArray(int[][] matrix, int rowLow, int rowHigh, int colLow, int colHigh, int target) {
        if (rowHigh < rowLow || colHigh < colLow) return false;
        
        if (rowLow == rowHigh && colLow == colHigh) {
            return target == matrix[rowLow][colLow];
        }
        
        int rowMid = rowLow + (rowHigh - rowLow) / 2;
        int colMid = colLow + (colHigh - colLow) / 2;
        int pivot = matrix[rowMid][colMid];
        
        if (target == pivot) {
            return true;
        }
        // Discard the bottom right
        else if (target < pivot) { 
            return searchSubArray(matrix, rowLow, rowHigh, colLow, colMid - 1, target) 
                    || searchSubArray(matrix, rowLow, rowMid - 1, colMid, colHigh, target);
        }
        // Dicard the top left
        else {
            return searchSubArray(matrix, rowMid + 1, rowHigh, colLow, colHigh, target)
                    || searchSubArray(matrix, rowLow, rowMid, colMid + 1, colHigh, target);
        }
    }
}
