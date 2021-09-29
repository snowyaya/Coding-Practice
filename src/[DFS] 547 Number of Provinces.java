// DFS 
// Time O(n) Space O(n)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[m];
        
        for (int i = 0; i < m; i++) {
                if (!visited[i]) {
                    dfs(isConnected, i, visited);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int[][] isConnected, int row, boolean[] visited) {
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i] && isConnected[row][i] == 1) {
                visited[i] = true;
                dfs(isConnected, i, visited);
            }
        }
    }
}

// No extra space for visited[][]
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        int count = 0;
        // boolean[] visited = new boolean[m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    isConnected[i][j] = 0;
                    count++;
                    dfs(isConnected, i);
                }
            }
            
        }
        return count;
    }
    
    public void dfs(int[][] isConnected, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = 0;
                dfs(isConnected, j);
            }
        }
    }
}
