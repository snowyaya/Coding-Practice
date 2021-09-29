class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count_fresh = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        
        if (count_fresh == 0) return 0; // there is no fresh orange from the beginning
        int count = 0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        // BFS starts from initially rotten orange
        while (!q.isEmpty()) {
            count++; // ???
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : directions) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    // if x or y is out of bound
                    // or the orange at (x , y) is already rotten
                    // or the cell at (x , y) is empty
                    // we do nothing
                    if (x < 0 || y < 0 || x >= m || y >= n || 
                        grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2; //mark the orange at (x , y) as rotten
                    q.offer(new int[]{x, y}); //put the new rotten orange at (x , y) in queue
                    count_fresh--;
                }
            }
        }
        if (count_fresh != 0) return -1;
        return count-1;
    }
}
