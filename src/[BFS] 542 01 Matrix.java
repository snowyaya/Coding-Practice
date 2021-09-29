class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q= new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i,j}); // ???
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] directions= {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : directions) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                if (x < 0 || y < 0 || x >= m || y >= n || 
                    mat[x][y] <= mat[curr[0]][curr[1]] + 1) {
                    continue;
                }
                q.add(new int[]{x, y}); // why add to queue???
                mat[x][y] = mat[curr[0]][curr[1]] + 1;
            }
        }
        return mat;
        
    }
}
