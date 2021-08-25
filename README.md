# I. [LeetCode Log](https://github.com/snowyaya/LeetCode-Daily-Practice/blob/master/LeetCode%20Log.md)
# II. LeetCode-Practice-Explanation
This table is the record of the LeetCode problems I have solved and the link to my video explanation is also attached.
| Problem |Type | Video | To be careful with | Useful resources
| --- | --- | --- | --- | --- |
| 323 | Union Find, DFS| [Number of Connected Components in Undirected Graph](https://drive.google.com/file/d/1dKj-ISvLeD69cJVjl5_ZdPD2QITQbrsd/view?usp=sharing) |
| 200 | Union Find, DFS | [Number of Islands](https://drive.google.com/file/d/1PBQnNPi5V-EglKhyLyTUKlEKboPDhh1Q/view?usp=sharing) |
| 232 | Queue, Stack | [Implement Queue with Stacks](https://drive.google.com/file/d/1XSxYgV1y920T3BhwJ2wRg2IVyl9mATUu/view?usp=sharing) |
| 236 | Binary Tree| [Lowest Common Ancestor of a Binary Tree: part1](https://drive.google.com/file/d/1UpiVikwsjdzRJhoi3R5qLqmQjDUgcO2E/view?usp=sharing) [part2](https://drive.google.com/file/d/1rM6KERa6JoJCmSFzDg3hHFcME7dqGs0O/view?usp=sharing)|
| 56 | Pointer, Interval | [Merge Intervals](https://drive.google.com/file/d/1da-Sk9Umm4WeYN4bsMW_WsUE_1CHO2aQ/view?usp=sharing) | sort 2D array by the first value of nested array:<br /> ```Arrays.sort(intervals, (array1, array2) -> Integer.compare(array1[0], array2[0]))```;<br /> convert a list of array to a 2D array:<br /> ```list.toArray(new int[list.size()][])```;| [Why do we use Lamda](https://www.programcreek.com/2014/01/why-lambda-java-8/)<br /> [Deep understanding of Arrays.sort()](https://www.programcreek.com/2013/11/arrays-sort-comparator/)<br /> [5 different Lamda expression](https://www.programcreek.com/2014/01/5-different-syntax-of-lambda-expression/)<br /> |
| 102 | Binary Tree | Level Order Traversal |
| 94 | Binary Tree | Inorder Traversal |
| 144 | Binary Tree | Preorder Traversal | If use iteration, investigate root.right before root.left because of using stack |
| 145 | Binary Tree | Postorder Traversal |
| 344 | String, Recursion | Reverse String |
| [24](https://leetcode.com/problems/swap-nodes-in-pairs/) | LinkedList, Recursion | Swap Nodes in Pairs | When using iteration, use a node temp, a node node, a node prev; remember the head is updated out of the while loop. |
| [206](https://leetcode.com/problems/reverse-linked-list/) | LinkedList, Recursion | Reverse Linked List | 

# III. Data Structure and Algorithms
## 1. Recursion
[Recurison in Programming (freeCodeCamp)](https://www.youtube.com/watch?v=IJDJ0kBx2LM)
## Big O Notation
[Big O Notation(freeCodeCamp)](https://www.youtube.com/watch?v=Mo4vesaut8g&t=784s)

## 1. Union Find | Disjoint Sets
### 1) what is union find?
[Reference](https://github.com/ryancheunggit/leetcode/blob/rise/note/union_find.md)
* Union Find is a data structure keeps track of a set of elements that are partitioned into a number of disjoint subsets.
* It has two operations `union(p, q)` and `find(p)`.
    * the __find/search__ finds the subset element p belongs to.
    * and __union/merge__ merges the subsets containing p and q.
* It memory usage is __O(N)__, and each find and union operations are near __O(1)__ in time.
* The algorithm can be used to find all connected components in a network.
* It is also used in kruskal's algorithm to find the minimal spanning tree for a graph.

### 2) Algorithms
* William Fiset
   * [Union Find Intro](https://www.youtube.com/watch?v=ibjEGG7ylHk&t=0s)
   * [Union find kruskal's algorithm](https://www.youtube.com/watch?v=JZBQLXgSGfs&t=0s)
   * [Union and Find](https://www.youtube.com/watch?v=0jNmHPfA_yE&t=0s)
   * [Path Compression](https://www.youtube.com/watch?v=VHRhJWacxis&t=0s)
   * [Source Code](https://www.youtube.com/watch?v=KbFlZYCpONw&t=0s)
* Tushar Roy
   * [Disjoint Sets using union by rank and path compression Graph Algorithm](https://www.youtube.com/watch?v=ID00PMy0-vE&t=1s)

### 3) Implementation (Java)
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
### 4) Use union find to find connected components in undirected graph
![Alt Text](https://raw.githubusercontent.com/ryancheunggit/leetcode/rise/note/assets/union_find_animation.gif)

```python
connections = [[0, 1], [1, 2], [2, 3], [3, 4], [5, 6], [6, 8], [7, 9]]

uf = UnionFind(10)
for p, q in connections: uf.union(p, q)
num_components = len(set(uf.find(i) for i in range(10)))
print(num_components)
```
## 3. Binary Tree
### 1) Traversal
#### a) Inorder (left -> root -> right)
```java
// Recursive
public void inorderTraversal(TreeNode root) {
   // left, root, right
   if (root == null) return;
   if (root.left != null) {
      inorderTraversal(root.left, output);
   }
   System.out.println(root.val);
   if (root.right != null) {
      inorderTraversal(root.right, output);
   }
}

// Iterative
public List<Integer> inorderTraversal(TreeNode root) {
   // left, root, right
   List<Integer> output = new ArrayList<Integer>();
   if (root == null) return output;
   Stack<TreeNode> s = new Stack<TreeNode>();

   while (true) {
      if (root != null) {
          s.push(root);
          root = root.left;
      } else {
          if (s.isEmpty()) {
              break;
          } else {
              root = s.pop();
              output.add(root.val);
              root = root.right;
          }
      }
   }
   return output;
}
```

#### b) Preorder (root -> left -> right; iterative investigate root.right then root.left)
```java
// Recursive
private void preOrderTraversal(TreeNode root) {
   if (root == null) return;
   Syste.out.println(root.val);
   if (root.left != null) {
      preOrderTraversal(root.left, output);
   }
   if (root.right != null) {
      preOrderTraversal(root.right, output);
   }
}

// Iterative
public void preorderTraversal(TreeNode root) {
   if (root == null) return output;
   Stack<TreeNode> s = new Stack<TreeNode>();
   s.push(root);
   while (!s.isEmpty()) {
      root = s.pop();
      System.out.println(root.val);
      if (root.right != null) {
          s.push(root.right);
      }
      if (root.left != null) {
          s.push(root.left);
      }
   }
   return output;
}
```

#### c) Postorder (left -> right -> root)
```java
// Recursive
public void postorderTraversal(TreeNode root) {
   if (root == null) return;
   if (root.left != null) {
      postorderTraversal(root.left, output);
   }
   if (root.right != null) {
      postorderTraversal(root.right, output);
   }
   System.out.println(root.val);
}

// Iterative
public void postorderTraversal(TreeNode root) {
   // left -> right -> root
   if (root == null) return;
   Stack<TreeNode> s = new Stack<TreeNode>();
   TreeNode current = root;
   while (current != null || !s.isEmpty()) {
      if (current != null) {
          s.push(current);
          current = current.left;
      } else {
          TreeNode temp = s.peek().right;
          if (temp == null) {
              temp = s.pop();
              System.out.println(temp.val);
              while (!s.isEmpty() && temp == s.peek().right) {
                  temp = s.pop();
                  System.out.println(temp.val);
              }
          } else {
              current = temp;
          }
      }
   }

   return output;
}        
```

#### d) Level order
```java
// Recursive
class LevelOrderTraversal {
   List<List<Integer>> levels = new ArrayList<List<Integer>>();

   public void helper(TreeNode node, int level) {
     // start the current level
     if (levels.size() == level)
         levels.add(new ArrayList<Integer>());

      // fulfil the current level
      levels.get(level).add(node.val);

      // process child nodes for the next level
      if (node.left != null)
         helper(node.left, level + 1);
      if (node.right != null)
         helper(node.right, level + 1);
   }

   public List<List<Integer>> levelOrder(TreeNode root) {
     if (root == null) return levels;
     helper(root, 0);
     return levels;
   }
}

// Iterative
public List<List<Integer>> levelOrder(TreeNode root) {
   List<List<Integer>> output = new ArrayList<>();
   if (root == null) return output;

   Queue<TreeNode> q = new LinkedList<TreeNode>();
   q.add(root);
   while (!q.isEmpty()) {
      List<Integer> levelList = new ArrayList<Integer>();
      int level = q.size();
      for (int i = 0; i < level; i++) {
          root = q.remove();
          levelList.add(root.val);
          if (root.left != null) {
              q.add(root.left);
          }
          if (root.right != null) {
              q.add(root.right);
          }
      }
      output.add(levelList);
   }
   return output;
}

public void levelOrder(TreeNode root) {
   if (root == null) return output;
   Queue<TreeNode> q = new LinkedList<TreeNode>();
   q.add(root);
   while (!q.isEmpty()) {
       TreeNode current = q.remove();
       System.out.println(current.val)
       if (current.left != null) {
           q.add(current.left);
       }
       if (current.right != null) {
           q.add(current.right);
       }
   }
}
```
