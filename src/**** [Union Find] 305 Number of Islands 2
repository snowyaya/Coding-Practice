class Solution {
    private int count = 0; // will hold count of islands
    private int[] parents;
    private int[][] grid;
    private int nRows; // number of rows
    private int nCols; // number of columns

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> result = new ArrayList<>();
        nRows = m;
        nCols = n;

        // prepare parents and grid
        parents = new int[nRows * nCols];
        grid = new int[nRows][nCols];

        for (int i = 0; i < nRows * nCols; i++) {
            parents[i] = i;
        }

        for (int[] landPosition : positions) {
            int i = landPosition[0];
            int j = landPosition[1];

            if( grid[i][j] == 0) {
                grid[i][j]= 1; // Make land

                // Increaee land counter
                count++;

                // Call unify to unify adjacent lands via union-find
                unifyAdjacentLands(i, j);
            }

            // Add current count
            result.add(count);
        }

        return result;
    }

    public void unifyAdjacentLands(int i, int j) {

        // unify with lower cell
        if ((i+1) < nRows && grid[i+1][j] == 1) {
            unify(i, j, i+1, j);
        }

         // unifiy with left cell
        if ((j - 1) >= 0 && grid[i][j - 1] == 1) {
            unify(i, j, i, j - 1);
        }

          // unifiy with right cell
        if ((j + 1) < nCols && grid[i][j+ 1] == 1) {
            unify(i, j, i, j+1);
         //   vistAdjacentLands(i,j+1);
        }

        // unify with upper cell
        if ((i - 1) >= 0 && grid[i - 1][j] == 1) {
            unify(i, j, i - 1, j);
        }

    }

    public void unify(int x1, int y1, int x2, int y2) {

        int rootx = find(x1, y1);
        int rooty = find(x2, y2);

        if (rootx != rooty) {

            parents[rootx] = rooty;
            // Decrease count of islands upon unify
            count--;
        }
    }

    public int find(int i, int j) {
        return find(i * nCols + j);
    }

    public int find(int root) {
        if (parents[root] != root) {
            parents[root] = find(parents[root]);
        }
        return parents[root];
    }
}
