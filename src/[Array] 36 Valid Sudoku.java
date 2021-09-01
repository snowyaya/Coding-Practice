class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // Iterate over each row
        for (int r = 0; r < rows; r++) {
            if (!checkRow(board, r, rows)) return false;
        }
        // Iterate over each column
        for (int c = 0; c < cols; c++) {
            if (!checkColumn(board, c, cols)) return false;
        }
        // Iterate over each sub 3*3 matrix
        if (!checkSubMatrix(board, 0, 2, 0, 2) ||
            !checkSubMatrix(board, 3, 5, 0, 2) ||
            !checkSubMatrix(board, 6, 8, 0, 2) ||
            !checkSubMatrix(board, 0, 2, 3, 5) ||
            !checkSubMatrix(board, 3, 5, 3, 5) ||
            !checkSubMatrix(board, 6, 8, 3, 5) ||
            !checkSubMatrix(board, 0, 2, 6, 8) ||
            !checkSubMatrix(board, 3, 5, 6, 8) ||
            !checkSubMatrix(board, 6, 8, 6, 8)) {
            return false;
        }
        return true;
    }
    
    public boolean checkRow(char[][] board, int r, int rows) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < rows; i++) {
            char cha = board[r][i];
            if (cha != '.') {
                if (!map.containsKey(cha)) {
                    map.put(cha, 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
     
    public boolean checkColumn(char[][] board, int c, int cols) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < cols; i++) {
            char cha = board[i][c];
            if (cha != '.') {
                if (!map.containsKey(cha)) {
                    map.put(cha, 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkSubMatrix(char[][] board, int left, int right, int top, int bottom) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                char cha = board[i][j];
                if (cha != '.') {
                    if (!map.containsKey(cha)) {
                        map.put(cha, 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
