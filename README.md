# LeetCode-Practice-Explanation
This table is the record of the LeetCode problems I have solved and the link to my video explanation is also attached.
| Problem |Type | Video | To be careful with | Useful resources
| --- | --- | --- | --- | --- |
| 323 | Union Find, DFS| [Number of Connected Components in Undirected Graph](https://drive.google.com/file/d/1dKj-ISvLeD69cJVjl5_ZdPD2QITQbrsd/view?usp=sharing) |
| 200 | Union Find, DFS | [Number of Islands](https://drive.google.com/file/d/1PBQnNPi5V-EglKhyLyTUKlEKboPDhh1Q/view?usp=sharing) |
| 232 | Queue, Stack | [Implement Queue with Stacks](https://drive.google.com/file/d/1XSxYgV1y920T3BhwJ2wRg2IVyl9mATUu/view?usp=sharing) |
| 236 | Binary Tree| [Lowest Common Ancestor of a Binary Tree: part1](https://drive.google.com/file/d/1UpiVikwsjdzRJhoi3R5qLqmQjDUgcO2E/view?usp=sharing) [part2](https://drive.google.com/file/d/1rM6KERa6JoJCmSFzDg3hHFcME7dqGs0O/view?usp=sharing)|
| 56 | Pointer, Interval | [To be done]() | sort 2D array by the first value of nested array:<br /> ```Arrays.sort(intervals, (array1, array2) -> Integer.compare(array1[0], array2[0]))```;<br /> convert a list of array to a 2D array:<br /> ```list.toArray(new int[list.size()][])```;| [Why do we use Lamda](https://www.programcreek.com/2014/01/why-lambda-java-8/)<br /> [Deep understanding of Arrays.sort()](https://www.programcreek.com/2013/11/arrays-sort-comparator/)<br /> [5 different Lamda expression](https://www.programcreek.com/2014/01/5-different-syntax-of-lambda-expression/)<br /> |

# Data Structure and Algorithms

## Union Find | Disjoint Sets
### what is union find?
[Reference](https://github.com/ryancheunggit/leetcode/blob/rise/note/union_find.md)
* Union Find is a data structure keeps track of a set of elements that are partitioned into a number of disjoint subsets.
* It has two operations `union(p, q)` and `find(p)`.
    * the __find/search__ finds the subset element p belongs to.
    * and __union/merge__ merges the subsets containing p and q.
* It memory usage is __O(N)__, and each find and union operations are near __O(1)__ in time.
* The algorithm can be used to find all connected components in a network.
* It is also used in kruskal's algorithm to find the minimal spanning tree for a graph.

### Algorithms
* William Fiset
   * [Union Find Intro](https://www.youtube.com/watch?v=ibjEGG7ylHk&t=0s)
   * [Union find kruskal's algorithm](https://www.youtube.com/watch?v=JZBQLXgSGfs&t=0s)
   * [Union and Find](https://www.youtube.com/watch?v=0jNmHPfA_yE&t=0s)
   * [Path Compression](https://www.youtube.com/watch?v=VHRhJWacxis&t=0s)
   * [Source Code](https://www.youtube.com/watch?v=KbFlZYCpONw&t=0s)
* Tushar Roy
   * [Disjoint Sets using union by rank and path compression Graph Algorithm](https://www.youtube.com/watch?v=ID00PMy0-vE&t=1s)

### Implementation (Java)
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
### Use union find to find connected components in undirected graph
![Alt Text](https://raw.githubusercontent.com/ryancheunggit/leetcode/rise/note/assets/union_find_animation.gif)

```python
connections = [[0, 1], [1, 2], [2, 3], [3, 4], [5, 6], [6, 8], [7, 9]]

uf = UnionFind(10)
for p, q in connections: uf.union(p, q)
num_components = len(set(uf.find(i) for i in range(10)))
print(num_components)
```
## Binary Tree
