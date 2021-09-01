class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int midRow = rows / 2;
        int midCol = cols / 2;
        
        int value = matrix[midRow][midCol];
        if (value == target) {
            return true;
        } else if (value < target) { // discard the bottom right 
            if (searchMatrix(matrix, target, 0, rows, midCol + 1, cols) ||
            searchMatrix(matrix, target, midRow + 1, rows, 0, midCol + 1)) {
                return true;
            }
        } else if (value > target) { // discard the top left
            if (searchMatrix(matrix, target, 0, rows, 0, midCol + 1) ||
                searchMatrix(matrix, target, 0, midRow + 1, midCol + 1, cols)) {
                    return true;
                }
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target, int top, int bottom, int left, int right) {
        for (int i = top; i < bottom; i++) {
            for (int j = left; j < right; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
