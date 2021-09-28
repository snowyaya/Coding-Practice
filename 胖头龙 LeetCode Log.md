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
## 2. 答案二分法
## 3. 条件二分法

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
- [ ] 🟣 Lint-127. [Topological Sorting](https://www.lintcode.com/problem/127/) 🔴
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
- [x] 🔵 207. Course Schedule
- [ ] 🔵 210. Course Schedule II
- [ ] 🔵 269. Alien Dictionary

## 3. Matrix
- [x] 🟣 200. Number of Islands
- [ ] 🔵 490. The Maze
- [ ] 🔵 505. The Maze II
- [ ] 🔵 542. 01 Matrix
- [ ] 🔵 733. Flood Fill
- [ ] 🔵 994. Rotting Oranges
- [ ] 🔵 305. Number of Islands II

## 4. Graph
- [ ] 🟣 133. Clone Graph
- [ ] 🔵 127. Word Ladder
- [ ] 🔵 261. Graph Valid Tree
- [ ] 🔵 841. Keys an Rooms

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

## 3. Graph

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
