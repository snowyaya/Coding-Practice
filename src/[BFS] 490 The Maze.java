// BFS

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
		visited[start[0]][start[1]] = true;
        
		int[][]directions= {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int[] currPos = q.poll();
            
            // found target point
            if (visited[destination[0]][destination[1]]) {
                return true;
            }
            
            // check for all directions
            for (int[] d : directions) {
                //Keep moving in a particular direction until we have met an obstacle or we're out of the maze.
                int x = currPos[0] + d[0];
                int y = currPos[1] + d[1];
				while(x >= 0 && y >= 0 && x < m && y < n && maze[x][y]==0) {
                    x += d[0];
                    y += d[1];
                }
                // we substract dir[0] & dir[1] from x and y 
                // as the while loop has given it an increased value which needs to be compensated for.
                if (!visited[x-d[0]][y-d[1]]) {
                    visited[x-d[0]][y-d[1]] = true;
                    q.add(new int[]{x-d[0], y-d[1]});
                }
            }
        }
        return false;
    }
}
