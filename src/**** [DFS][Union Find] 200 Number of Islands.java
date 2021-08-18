// This is the DFS solution
// Sink the island after it's detected as an island by setting it to '0'.
class Solution {
    public int numIslands(char[][] grid) {
        // Error check
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        // Get the vertical height of the grid
        int row = grid.length;
        // Get the horizontal length of the grid
        int col = grid[0].length;
        // Initialize the number of island as 0
        int islands = 0;
        
        // Iterate over each block of the grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') { // If the block has char '1'
                    islands++; // Increament the number of islands
                    dfs(grid, i, j); // Visit all neighbors of the island
                }
            }
        }
        return islands; // Return the number of islands
    }
    
    void dfs(char[][] grid, int row, int col) {
        // Get the vertical height of the grid
        int r = grid.length;
        // Get the horizontal length of the grid
        int c = grid[0].length;
        
        // Error check
        // Make sure what we are checking is within the matrix bound
        // Also, we don't visit if the block is zero
        // When any of those happens, we simply return 
        if (row < 0 || col < 0 || row >= r || col >= c || grid[row][col] == '0' ) {
            return;
        }
        
        // Set the visited island to 0 so we won't revisit it
        grid[row][col] = '0';
        // Now visit all neighbors
        dfs(grid, row - 1, col); // The neighbor above
        dfs(grid, row + 1, col); // The neighbor below
        dfs(grid, row, col - 1); // The neighbor to the left
        dfs(grid, row, col + 1); // The neighbor to the right
    }
}
