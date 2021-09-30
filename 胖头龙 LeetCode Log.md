## Focus on growth; Aim Small; Be consistant.
#### Note
> This document is used to keep track of the solved LeetCode problems following the lists below. <br/>
> Credit to [胖头龙的刷题笔记](https://www.1point3acres.com/bbs/thread-678970-1-1.html) and [Joshua LeetCode Summary](http://joshuablog.herokuapp.com/Leetcode-%E6%80%BB%E7%BB%93.html) <br/>

## Strategy
🟣 Must
🔵 Core
🟢 Important
<br/>
🔴 Not mastered
🟡 Sort of mastered
🟤 mastered

| Strategy | Description |
| --- | --- |
| 初刷 | 1) It's okay to 'copy' the solution, but use your own style to write the code <br/> 2) ~30 min/each |
| 精刷 | 1) Fully understand the solution <br/> 2) Take notes of the algorithms <br/>  3) Mark the problem if cannot fully understand <br/> 4) ~ 60 min/each |
| 复刷 | 1) Speak your algorithms loud <br/> 2) Refer to the notes and solution <br/> 3) Reflect on where needs improving <br/> 4) ~20 min/each |
| 回顾 | 1) Review by tags <br/> 2) Go over algorithms in mind <br/> 3) Solidify the memory, DO NOT WRITE CODE <br/> 4) ~5-10 min/each |
| 讲解 | 1) Teach on whiteboard |
| 模拟 | 1) New problem <br/> 2) ~30 min/each|

### 1st step: 初刷 🟣 + 🔵 [NOW]

### 2nd step: 精刷 🟣

### 3rd step: 精刷 🔵

### 4th step: 初刷 🟢


### 5th step: 复刷 🟣 + 🔵 


### 6th step: 精刷 🟢 + 回顾 (🟣 + 🔵)

### 7th step: 复刷 (🟣 + 🔵) + 回顾 🟢

### 8th step: 复刷 🟢 + 回顾 ALL

### 9th step:  回顾 ALL + MOCK


# I. Binary Search
## 1. 朴素二分法
- [ ] 🟣 704. Binary Search
- [ ] 🔵 34. Find First and Last Position of Element in Sorted Array
- [ ] 🔵 702. Search in a Sorted Array of Unknown Size
- [ ] 🟢 153. Find Minimum in Rotated Sorted Array
- [ ] 🟢 154. Find Minimum in Rotated Sorted Array II
- [ ] 🟢 278. First Bad Version
- [ ] 🟢 658. Find K Closest Elements

## 2. 答案二分法
- [ ] 🟣 33. Search in Rotated Sorted Array
- [ ] 🟣 81. Search in Rotated Sorted Array II
- [ ] 🔵 4. Median of Two Sorted Arrays
- [ ] 🔵 74. Search a 2D Matrix
- [ ] 🔵 162. Find Peak Element
- [ ] 🟢 302. Smallest Rectangle enclosing Black Pixels
- [ ] 🟢 852. Peak Index in a Mountain Array

## 3. 条件二分法
- [ ] 🔵 875. Koko Eating Bananas
- [ ] 🔵 1283. Find the Smallest Divisor Given a Threshold
- [ ] 🟢 69. Sqrt(x)
- [ ] 🟢 Lint-586. Sqrt(x) II
- [ ] 🟢 Lint-183. Wood Cut
- [ ] 🟢 Lint-437.Copy Books
- [ ] 🟢 Lint-438. Copy Books II

# II. Pointers
## 1. Array
- [x] 🟣 912. Sort An Array (quick sort and merge sort)
- [x] 🟣 75. Sort Colors
- [x] 🔵 26. Remove Duplicates from Sorted Array
- [x] 🔵 80. Remove Duplicateds from Sorted Array II
- [x] 🔵 88. Merge Sorted Array
- [x] 🔵 283. Move Zeroes
- [x] 🔵 215. Kth Largest Element in an Array
- [x] 🔵 347. Top K Frequent Elements
- [x] 🔵 349. Intersections of Two Arrays
- [x] 🔵 350. Intersections of Two Arrays II
- [x] 🔵 845. Longest Mountain in Array
- [x] 🔵 42. Trapping Rain Water
- [x] 🔵 43. Multiply Strings

## 2. Linked List
- [x] 🟣 21. Merge Two Sorted Lists
- [x] 🔵 86. Partition List
- [x] 🔵 141. Linked List Cycle
- [x] 🔵 160. Intersection of Two Linked List
- [x] 🔵 234. Palindrome Linked List
- [x] 🔵 328. Odd Even Linked List

## 3. Sliding Window
- [ ] 🟣 3. Longest Substring without Repeating Characters
- [ ] 🔵 11. Container With Most Water
- [ ] 🔵 76. Minimum Window Substring
- [x] 🔵 209. Monimum Size Subarray Sum
- [x] 🔵 239. Sliding Window Maximum
- [x] 🔵 713. Subarray Product Less Than K

## 4. Interval
- [x] 🔵 56. Merge Intervals
- [ ] 🔵 57. Insert Interval
- [ ] 🔵 252. meeting Rooms
- [ ] 🔵 253. Meeting Rooms II
- [x] 🔵 986. Interval List Intersections

## 5. String
- [x] 🔵 5. Longest Palindromic Substring
- [x] 🔵 345. Reverse Vowels of a String
- [x] 🔵 680. Valid Palindrome II

## 6. Stream
- [x] 🔵 295. Find Mediam from Data Stream

## 7. Subarray
- [x] 🟣 53. Maximum Subarray
- [ ] 🔵 238. Product of Array Except Self
- [ ] 🔵 303. Range Sum Query - Immutable
- [ ] 🔵 325. Maximum Size Subarray Sum equals K
- [ ] 🔵 528. Random Pick with Weight
- [ ] 🔵 560. Subarray Sum Equals K

## 8. Sum and Difference
- [x] 🟣 1. Two Sum
- [x] 🔵 15. 3Sum
- [ ] 🔵 18. 4Sum


# III. BFS
## 1. Binary Tree
- [x] 🟣 297. [Serialize and Deserialize Binary Tree](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20297.%20Serialize%20and%20Deserialize%20Binary%20Tree.java) 🔴
* `serialize(TreeNode root)`
> use level order
use `Queue` to traverse by level
```java
StringBuilder str = new StringBuilder()
str.append("x,") 
q.append(curr.left)
```
> recursion
`return root.val + "," + serialize(root.left) + "," + serialize(root.right)`
---
* `deserialize(String data)`
> use level order
```java
String[] values = data.split(",");
int i = 0;
TreeNode root = new TreeNode(Integer.valueOf(values[i++]))
while (!q.isEmpty()) {
  curr = q.remove()
  if (!values[i].equals("x")) {
    update curr.left
    add curr.left to q
  }
  i++
  if (!values[i].equals("x")) {
    update curr.right
    add curr.right to q
  }
  i++
}
```

> use recursion
* use a `helperD`
```java
Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));`
String helperD(q) {
  s = q.poll()
  if (curr == null) return null
  root = new TreeNode(s)
  root.left = helperD(q)
  root.right = helperD(q)
  return root
}
```
---

- [x] 🔵 102. [Binary Tree Level Order Traversal](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBinary%20Tree%5D%20102%20Level%20Order%20Binary%20Tree%20Traversal.java) 🔴
* return `[[],[],[],...]`
* use `queue` to store the level list
* use `list` to store the level values
```java
q.add(root)
while (!q.isEmpty()) {
  new list;
  level = q.size()
  for (i < level.size()) {
    root = q.remove()
    list.add(root) // root added
    if leftchild {
      q.add(leftchild) // leftchild added
    }
    if rightchild {
      q.add(rightchild) // rightchild added
    }
  }
  output.add(list)
}
```
---

- [x] 🔵 103. [Binary Tree Zigzag Level Order Traversal](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20103.%20Binary%20Tree%20Zigzag%20Level%20Order%20Traversal.java) 🔴
* use `Collections.reverse()` to get the odd level nodes
```java
if (!levelList.isEmpty()) {
  if (level % 2 == 1) {
    Collections.reverse();
  }
  output.add(levelList);
}
```
---

- [x] 🔵 107. Binary Tree Level Order Traversal II 🟤
* use `Collections.reverse()` at the end
* can also use `output.add(0, levelList)` after each level for loop
---

- [x] 🔵 513. Find Bottom Left Tree Value 🟤
* Be careful with when to return the bottom leftmost value
* `if (q.isEmpty()) return levelList.get(0)`

---

## 2. Topological Sort
- [x] 🟣 Lint-127. [Topological Sorting](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20Lint-127%20Topological%20Sort.java) 🔴
* BFS???
```java
public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList();
        Map<DirectedGraphNode, Integer> indegree = new HashMap();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode nei : node.neighbors) {
                indegree.putIfAbsent(node, 0); // note: need to add node itself to start
                indegree.put(nei, indegree.getOrDefault(nei, 0) + 1);
            }
        }

        Queue<DirectedGraphNode> q = new LinkedList();
        for(DirectedGraphNode key : indegree.keySet()) {
            if(indegree.get(key) == 0) q.add(key);
        }

        while(q.size() > 0) {
            DirectedGraphNode node = q.poll();
            res.add(node);
            for(DirectedGraphNode nei : node.neighbors) {
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0) q.add(nei);
            }
        }
        return res;
    }
```

---
- [x] 🔵 207. [Course Schedule](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20207%20Course%20Schedule.java) 🔴
* [video (in Chinese)](https://www.youtube.com/watch?v=m9jUbHKQjGc)
* We will use a hash map to store each course and its prerequisites. 
-> We will use a hashset to store each to-be-visited course, remove it after the course and its prerequisites get fully visited. 
-> To get this done, we will use DFS to fully visit every course.
-> The base case is when the course is already in the to-be-visited set, dfs returns false, because that means there's a loop in the graph and a course cannot be the prerequisite for itself.
-> If a course's prerequisites list is empty, meaning completing this course doesn't require completing
any other course, so this course can be completed and dfs should return true.
* After we finished visiting the course, remove it from the visit set so we won't have to visit it again.
`visit.remove(course);`
* Set the course's prerequisite list to an empty list so we won't have to revisit the prerequisites.
`preMap.replace(course, new ArrayList<>());`
---        

- [x] 🔵 210. [Course Schedule II](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20210%20Course%20Schedule%20II.java) 🔴
* 把course 和 preReq放进一个hashmap里，preReq是key，course放进value的list里面，但是在207 Course Schedule，刚好是反过来的
* get `Indegrees` -> get `preMap` -> do `topoSort`
---

- [x] 🔵 269. [Alien Dictionary](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20269%20Alien%20Dictionary.java) 🔴
* [video (in Chinese)](https://www.youtube.com/watch?v=hWnvHiaXTsw)
* `map` for `Map<Character, Set<Character>> map = new HashMap<>();`
* `Map<Character, Integer> indegrees = new HashMap<>();`
* In a valid alphabet, prefixes are always first
`if (curr.length() > next.length() && curr.startsWith(next)) return "";`

---

## 3. Matrix
- [x] 🟣 200. Number of Islands
- [x] 🔵 490. [The Maze](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20490%20The%20Maze.java) 🔴
* `boolean[][] visited = new boolean[m][n];`
* `Queue<int[]> q = new LinkedList<>();`
*  `int[][]directions= {{-1,0},{1,0},{0,-1},{0,1}};`
```
while q is not empty:
  poll out the currpos in q
  if the curr postions == destination, return true
  else:
    check all directions
    x = currpos[0] + d[0]
    y = currpos[1] + d[1]
    keep visiting all directions
    if not visited: 
      add to visited (decrement x and y)
      add to q
```
---
        
- [x] 🔵 505. The Maze II
- [x] 🔵 542. [01 Matrix](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20542%2001%20Matrix.java) 🔴
* At beginning, set cell value to Integer.MAX_VALUE if it is not 0.
* If newly calculated distance >= current distance, then we don't need to explore that cell again.
---

- [x] 🔵 733. Flood Fill
* **NOT understand the problem!

---

- [x] 🔵 994. [Rotting Oranges](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20994%20Rotton%20Oranges.java) 🔴
* offer to rotten queue and count fresh oranges => `if fresh_count == 0, return 0`, if not => rotten all directions, count++
* while rottening all directions, if `x, y` out of bound, or `[x][y] == 2 or == 0`, `continue;` else 1) rotten the orange 2) offer rotten oranges to queue 3) fresh_count--;
* `if grid[i][j] == 2, q.offer(new int[]{i,j});`
* `if grid[i][j] == 1, fresh_count++;`
---

- [x] 🟢 305. Number of Islands II

---

## 4. Graph
- [x] 🟣 133. Clone Graph 🔴
* **?? hard to imagine how the newNode is created??**
* use `map` to store visited nodes
* use `queue` to store original nodes need to be visited
* add to map and queue if this node hasn't been visited
* if this node has been visited, add neighbor to newly created nodes
---

- [x] 🔵 127. [Word Ladder](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20127%20Word%20Ladder.java) 🔴
* **NOT Understang AT ALL!!!
---

- [x] 🔵 261. [Graph Valid Tree](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20261%20Graph%20Valid%20Tree.java) 🔴
* use `map` to store the edges info
* use `set` to store the explored nodes
* use `queue` to store the nodes need to be explored
* if the node found to be existing in set already, return false **need to know when to return false**
* if not, 1)explore the neighbors 2) removing the edge 3) add to set afterwards

---

- [x] 🔵 841. [Keys an Rooms](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BBFS%5D%20841%20Rooms%20and%20Keys.java) 🟡
* `map` is not needed because we don't need to store no directed or undirect edges 
* `set` to store the visited rooms
* `queue` to store the to be visited rooms
* start from visiting room 0, `q.offer(0)` & `visited.add(0)`
* when room is found to be visited, `continue`
* otherwise, visit the room
* in the end, if all room can be visited, `rooms.size() == visited.size();`
---

# IV. Binary Tree and Recursion
## 1. Traversal (Also need to be skilled with iteration)
- [x] 🟣 94. Binary Tree Inorder Traversal
- [x] 🟣 144. Binary Tree Preorder Traversal
- [x] 🟣 145. Binary Tree Postorder Traversal
- [ ] 🟣 105. Construct Binary Tree from Preorder and Inorder Traversal
- [ ] 🔵 106. Construct Binary Tree from Inorder and Postorder Traversal
- [ ] 🔵 889. Construct Binary Tree from Preorder and Postorder Traversal

## 2. Iterator
- [ ] 🟣 173. Binary Search Tree Iterator
- [ ] 🔵 230. Kth Smallest Element in a BST
- [ ] 🔵 285. Inorder Successor in BST
- [ ] 🟢 270. Closest Binary Search Tree Value
- [ ] 🟢 272. Closest Binary Search Tree Value II
- [ ] 🟢 510. Inorder Successor in BST II

## 3. Subtree
- [ ] 🔵 111. Minimum Depth of Binary Tree
- [x] 🟢 104. Maximum Depth of Binary Tree
- [ ] 🟢 333. Largest BST Subtree

## 4. LCA
- [x] 🔵 236. Lowest Common Ancestor of a Binary Tree
- [x] 🟢 235. Lowest Common Ancestor of a Binary Search Tree
- [ ] 🔵 1650. Lowest Common Ancestor of a Binary Tree III

## 5. Tree Type
- [x] 🔵 98. Validate Binary Search Tree
- [ ] 🔵 100. Same Tree
- [x] 🔵 101. Symmetric Tree
- [x] 🔵 110. Balanced Binary Tree

## 6. Path
- [ ] 🔵 112. Path Sum
- [ ] 🔵 113. Path Sum II
- [ ] 🔵 124. Binary Tree Maximum Path Sum
- [ ] 🟢 298. Binary Tree Longest Consecutive Sequence
- [ ] 🟢 549. Binary Tree Longest Consecutive Sequence II

## 7. Others
- [ ] 🔵 199. Binary Tree Right Side View
- [ ] 🔵 513. Find Bottom Left Tree Value
- [ ] 🔵 331. Verify Preorder Serialization of a Binary Tree
- [ ] 🔵 449. Serialize and Deserialize BST
- [ ] 🟢 114. Flatten Binary Tree to Linked List

# V. DFS
## 1. Combinations/Permutations

## 2. Binary Tree
- [x] 🔵 113. [Path Sum II](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BDFS%5D%20113%20Path%20Sum%20II.java) 🔴
* use recursion
* be aware of when `getPath()` should return `null`, when `root == null`
* after `targetSum -= root.val`, need to add `root.val` to the nested `list`
* understand when to add the nested `list` to the output `list`, when `left == null && right == null && targetSum == 0`, meaning we are now at an expected position, so we can have `out.add(new ArrayList<>(list))`
* if not reached the bast case, keep `getPath()` from `root.left` and `root.right`
* lastly, `list.remove(list.size()-1)` // remove the last element if the targetSum != 0

---

- [x] 🔵 257. [Binary Tree Paths](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BDFS%5D%20257%20Binary%20Tree%20Paths.java) 🟤
* be clear with the corner case, which is `root==null`
* be careful with the base case, meaning in what case the methd should return the expected result, `root.left==null && root.righ==null`

---

- [ ] 🔵 Lint-246. Binary Tree Path Sum II
- [ ] 🔵 Lint-376. Binary Tree Path Sum
- [ ] 🔵 Lint-472. Binary Tree Path Sum III

## 3. Graph
- [x] 🔵 547. [Number of Provinces](https://github.com/snowyaya/SWE-Interview-Prep/blob/master/src/%5BDFS%5D%20547%20Number%20of%20Provinces.java) 🔴
* one way is to have a `visited[][]` and set `visited[i][j]=true` after visited it
* another way to save the extra space for `visited[][]` is to set the `isConnected[i][j] = 0` after visited it.

---

- [ ] 🔵 140. Word Break II
- [ ] 🔵 494. Target Sum
- [ ] 🔵 1192. Critical Connections is a Network
- [ ] 🟢 12. Word Ladder II
- [ ] 🟢 290. Word Pattern
- [ ] 🟢 291. Word Pattern II

# VI. Data Structures
## 1. Array & Matrix

## 2. Linked List

## 3. String

## 4. Hash

## 5. Stack

## 6. Union Find

## 7. Sweep Line

## 8. Complex Data Structure

## 9. Heap

## 10. Monotonic Stack

## 11. Trie

## 12. Binary Index Tree & Segment Tree

# VII. Dynamic Programming
## 1. Backpack

## 2. Single Sequence

## 3. Double Sequences

## 4. Sections

## 5. Matrix

## 6. Greedy

## 7. Others
