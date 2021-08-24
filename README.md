# LeetCode-Practice-Explanation
This table is the record of the LeetCode problems I have solved and the link to my video explanation is also attached.
| Problem | Video |
| --- | --- |
| 323 | [Number of Connected Components in Undirected Graph](https://drive.google.com/file/d/1dKj-ISvLeD69cJVjl5_ZdPD2QITQbrsd/view?usp=sharing) |
| 200 | [Number of Islands](https://drive.google.com/file/d/1PBQnNPi5V-EglKhyLyTUKlEKboPDhh1Q/view?usp=sharing) |
| 232 | [Implement Queue with Stacks](https://drive.google.com/file/d/1XSxYgV1y920T3BhwJ2wRg2IVyl9mATUu/view?usp=sharing) |
| 236 | [Lowest Common Ancestor of a Binary Tree: part1](https://drive.google.com/file/d/1UpiVikwsjdzRJhoi3R5qLqmQjDUgcO2E/view?usp=sharing) [part2](https://drive.google.com/file/d/1rM6KERa6JoJCmSFzDg3hHFcME7dqGs0O/view?usp=sharing)|

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

## Algorithms
* William Fiset
   * [Union Find Intro](https://www.youtube.com/watch?v=ibjEGG7ylHk&t=0s)
   * [Union find kruskal's algorithm](https://www.youtube.com/watch?v=JZBQLXgSGfs&t=0s)
   * [Union and Find](https://www.youtube.com/watch?v=0jNmHPfA_yE&t=0s)
   * [Path Compression](https://www.youtube.com/watch?v=VHRhJWacxis&t=0s)
   * [Source Code](https://www.youtube.com/watch?v=KbFlZYCpONw&t=0s)
* Tushar Roy
   * [Disjoint Sets using union by rank and path compression Graph Algorithm](https://www.youtube.com/watch?v=ID00PMy0-vE&t=1s)

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
## Use union find to find connected components in undirected graph
![Alt Text](https://raw.githubusercontent.com/ryancheunggit/leetcode/rise/note/assets/union_find_animation.gif)

```python
connections = [[0, 1], [1, 2], [2, 3], [3, 4], [5, 6], [6, 8], [7, 9]]

uf = UnionFind(10)
for p, q in connections: uf.union(p, q)
num_components = len(set(uf.find(i) for i in range(10)))
print(num_components)
```

## Example Problems
* 200 Number of Islands (DFS is better)
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
* 323 Number of Connected Components in Undirected Graph
```java
class Solution {
    public int countComponents(int n, int[][] edges) {
        // initialize from 0 to n-1
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = Find(edges[i][0], nums);
            int y = Find(edges[i][1], nums);
            // if two vertices happen to be in the same set
            // then no need to union, continue
            if (x == y) continue;
            // if both x and y are separate, union them
            nums[x] = y;
        }
            
        // find the number of root, since hashset will keep unique values
        // avoid storing repeating root values
        Set<Integer> count = new HashSet<>();
        for(int i = 0; i < n; i++){
            count.add(Find(i, nums));
        }
        
        return count.size();
    }
    
    public int Find(int x, int nums[]) {
        while (nums[x] != x) {
            nums[x] = nums[nums[x]];
            x = nums[x];
        }
        return x;
    }
}
```

```java
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1)
            return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfsVisit(i, map, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfsVisit(int i, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        for (int j : map.get(i)) {
            if (visited.add(j))
                dfsVisit(j, map, visited);
        }
    }
}
```
# Binary Tree
## LCA
### Example Problems
* 236 Lowest Common Ancestor of a Binary Tree 
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */ 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.equals(q)) return p;
        
        Stack<TreeNode> pathToP = this.pathTo(root, p);
        Stack<TreeNode> pathToQ = this.pathTo(root, q);
        
        if (pathToP == null || pathToQ == null) return null;
        
        TreeNode prev = null;
        while (!pathToP.isEmpty() && ! pathToQ.isEmpty()) {
            TreeNode s = pathToP.pop();
            TreeNode t = pathToQ.pop();
            if (s.equals(t)) {
                prev = s;
            } else {
                break;
            }
        }
        return prev;
    }
    
    public Stack<TreeNode> pathTo(TreeNode tree, TreeNode n) {
        // Two base cases
        if (tree == null) return null;
        if (tree.equals(n)) {
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(tree);
            return s;
        }
        
        // Assume each node is unique in the tree
        Stack<TreeNode> left = pathTo(tree.left, n);
        Stack<TreeNode> right = pathTo(tree.right, n);
        if (left != null) {
            left.push(tree);
            return left;
        }
        if (right != null) {
            right.push(tree);
            return right;
        }
        return null;
    }
}
```

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        
        if (root == p || root == q) {
            return root;
        } 
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        }
        
        return left != null ? left : right;
    }
}
```
