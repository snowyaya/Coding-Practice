class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int sol[] = new int[m*n];
        int row = 0, col = 0;
        for(int i = 0; i < sol.length; i++) {
            sol[i] = matrix[row][col];
            if((row+col)%2 == 0) {              // go up
                if(col == n-1) row++;           // corner case of last column
                else if(row == 0) col++;        // corner case of first row
                else { row--; col++;}           // normal update to go up diagonally
            } else {                            // go down
                if(row == m-1) col++;           // corner case of last row
                else if(col == 0) row++;        // corner case of first column
                else { row++; col--;}           // normal update to go down diagonally
            }
        }
        return sol;
    }
}
