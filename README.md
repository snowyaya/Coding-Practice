# LeetCode-Practice-Explanation
I will put the link of my explanation, other's explanation, or other's explanation (video) reference here for the learning purp

# Union Find | Disjoint Sets
## what is union find?
[Reference](https://github.com/ryancheunggit/leetcode/blob/rise/note/union_find.md)
* Union Find is a data structure keeps track of a set of elements that are partitioned into a number of disjoint subsets.
* It has two operations `union(p, q)` and `find(p)`.
    * the __find/search__ finds the subset element p belongs to.
    * and __union/merge__ merges the subsets containing p and q.
* It memory usage is __O(N)__, and each find and union operations are near __O(1)__ in time.
* The algorithm can be used to find all connected components in a network.
* It is also used in kruskal's algorithm to find the minimal spanning tree for a graph.

## Implementation (Java)
```java
public class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (var i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
 
    public int Find(int x) {
        if (x == parent[x]) {
            return x;
        }
        // compress the paths
        return parent[x] = Find(parent[x]);
    }
 
    public void Union(int x, int y)  {
        var px = Find(x);
        var py = Find(y);
        if (px != py) {
            parent[px] = py;
        }
    }
 
    public int size() { // number of groups
        int ans = 0;
        for (int i = 0; i < parent.length(); ++ i) {
            if (i == parent[i]) ans ++;
        }
        return ans;
    }  
}
```

## Example Problems
* 200 Number of Islands (DFS is better)
  * [my explanation]
```java
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
```
* 305 Number of Islands 2 
  * [my explanation]
 ```java
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
```
