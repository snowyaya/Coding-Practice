# Coding Practice

This coding practice refers to [胖胖龙的刷题笔记](胖胖龙刷题方法.pdf)

## I. Progress
> Focus on growth; Aim Small; Be consistant.

Strategy

> 🟣 Must
> 🔵 Core
> 🟢 Important
> 🔴 Need revisit


### Binary Search
#### 1. 朴素二分法
- [x] 🟣 704. Binary Search
- [x] 🔵 34. Find First and Last Position of Element in Sorted Array
```python
def find_left(nums, target):
    ans = -1
    left = 0
    right = len(nums) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        if target < nums[mid]:
            right = mid - 1
        elif target > nums[mid]:
            left = mid + 1
        else:
            ans = mid
            right = mid - 1
    return ans
            
    
def find_right(nums, target):
    ans = -1
    left = 0
    right = len(nums) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        if target < nums[mid]:
            right = mid - 1
        elif target > nums[mid]:
            left = mid + 1
        else:
            ans = mid
            left = mid + 1
    return ans


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if (nums is None) or len(nums) == 0: return [-1, -1]
        
        left_bound = find_left(nums, target)
        right_bound = find_right(nums, target)
        return [left_bound, right_bound]
```
- [x] 🔵 702. Search in a Sorted Array of Unknown Size

```python
def search(self, reader: 'ArrayReader', target: int) -> int:
    if (reader.get(0) is None) or (target < reader.get(0)): return -1
    left = 0
    right = 1
    while target > reader.get(right):
        right *= 2

    while left <= right:
        mid = (left + right) // 2

        if target < reader.get(mid):
            right = mid - 1
        elif target > reader.get(mid):
            left = mid + 1
        else:
            return mid
    return -1
```

```python
def helper(reader, target, index):
    if not reader.get(index): return -1;
    
    if target < reader.get(index): 
        return find(reader, target, 0, index)
    elif target > reader.get(index):
        return helper(reader, target, (index + 1) * 2)
    else:
        return index
    
def find(reader, target, left, right):
    if (left > right): return -1
    while left <= right:
        mid = left + (right - left) // 2
        if target < reader.get(mid):
            right = mid - 1
        elif target > reader.get(mid):
            left = mid + 1
        else:
            return mid
    return -1
    

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) is None: return -1
        if target < reader.get(0): return -1
        return helper(reader, target, 0)  
```

- [ ] 🟢 153. Find Minimum in Rotated Sorted Array
- [ ] 🟢 154. Find Minimum in Rotated Sorted Array II
- [ ] 🟢 278. First Bad Version
- [ ] 🟢 658. Find K Closest Elements

#### 2. 答案二分法
- [ ] 🟣 33. Search in Rotated Sorted Array
- [ ] 🟣 81. Search in Rotated Sorted Array II
- [ ] 🔵 4. Median of Two Sorted Arrays
- [ ] 🔵 74. Search a 2D Matrix
- [ ] 🔵 162. Find Peak Element
- [ ] 🟢 302. Smallest Rectangle enclosing Black Pixels
- [ ] 🟢 852. Peak Index in a Mountain Array

#### 3. 条件二分法
- [ ] 🔵 875. Koko Eating Bananas
- [ ] 🔵 1283. Find the Smallest Divisor Given a Threshold
- [ ] 🟢 69. Sqrt(x)
- [ ] 🟢 Lint-586. Sqrt(x) II
- [ ] 🟢 Lint-183. Wood Cut
- [ ] 🟢 Lint-437.Copy Books
- [ ] 🟢 Lint-438. Copy Books II

### Pointers
#### 1. Array
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

#### 2. Linked List
- [x] 🟣 21. Merge Two Sorted Lists
- [x] 🔵 86. Partition List
- [x] 🔵 141. Linked List Cycle
- [x] 🔵 160. Intersection of Two Linked List
- [x] 🔵 234. Palindrome Linked List
- [x] 🔵 328. Odd Even Linked List

#### 3. Sliding Window
- [ ] 🟣 3. Longest Substring without Repeating Characters
- [ ] 🔵 11. Container With Most Water
- [ ] 🔵 76. Minimum Window Substring
- [x] 🔵 209. Monimum Size Subarray Sum
- [x] 🔵 239. Sliding Window Maximum
- [x] 🔵 713. Subarray Product Less Than K

#### 4. Interval
- [x] 🔵 56. Merge Intervals
- [ ] 🔵 57. Insert Interval
- [ ] 🔵 252. meeting Rooms
- [ ] 🔵 253. Meeting Rooms II
- [x] 🔵 986. Interval List Intersections

#### 5. String
- [x] 🔵 5. Longest Palindromic Substring
- [x] 🔵 345. Reverse Vowels of a String
- [x] 🔵 680. Valid Palindrome II

#### 6. Stream
- [x] 🔵 295. Find Mediam from Data Stream

#### 7. Subarray
- [x] 🟣 53. Maximum Subarray
- [ ] 🔵 238. Product of Array Except Self
- [ ] 🔵 303. Range Sum Query - Immutable
- [ ] 🔵 325. Maximum Size Subarray Sum equals K
- [ ] 🔵 528. Random Pick with Weight
- [ ] 🔵 560. Subarray Sum Equals K

#### 8. Sum and Difference
- [x] 🟣 1. Two Sum
- [x] 🔵 15. 3Sum
- [ ] 🔵 18. 4Sum


### BFS
#### 1. Binary Tree
- [x] 🟣 297. Serialize and Deserialize Binary Tree
- [x] 🔵 102. Binary Tree Level Order Traversal
- [x] 🔵 103. Binary Tree Zigzag Level Order Traversal
- [x] 🔵 107. Binary Tree Level Order Traversal II 
- [x] 🔵 513. Find Bottom Left Tree Value �

#### 2. Topological Sort
- [x] 🟣 Lint-127. Topological Sorting
- [x] 🔵 207. Course Schedule
- [x] 🔵 210. Course Schedule II
- [x] 🔵 269. Alien Dictionary

#### 3. Matrix
- [x] 🟣 200. Number of Islands
- [x] 🔵 490. The Maze
- [x] 🔵 505. The Maze II
- [x] 🔵 542. 01 Matrix
- [x] 🔵 733. Flood Fill
- [x] 🔵 994. Rotting Oranges
- [x] 🟢 305. Number of Islands II

#### 4. Graph
- [x] 🟣 133. Clone Graph
- [x] 🔵 127. Word Ladder
- [x] 🔵 261. Graph Valid Tree
- [x] 🔵 841. Keys an Rooms


### Binary Tree and Recursion
#### 1. Traversal (Also need to be skilled with iteration)
- [x] 🟣 94. Binary Tree Inorder Traversal
- [x] 🟣 144. Binary Tree Preorder Traversal
- [x] 🟣 145. Binary Tree Postorder Traversal
- [ ] 🟣 105. Construct Binary Tree from Preorder and Inorder Traversal
- [ ] 🔵 106. Construct Binary Tree from Inorder and Postorder Traversal
- [ ] 🔵 889. Construct Binary Tree from Preorder and Postorder Traversal

#### 2. Iterator
- [ ] 🟣 173. Binary Search Tree Iterator
- [ ] 🔵 230. Kth Smallest Element in a BST
- [ ] 🔵 285. Inorder Successor in BST
- [ ] 🟢 270. Closest Binary Search Tree Value
- [ ] 🟢 272. Closest Binary Search Tree Value II
- [ ] 🟢 510. Inorder Successor in BST II

#### 3. Subtree
- [ ] 🔵 111. Minimum Depth of Binary Tree
- [x] 🟢 104. Maximum Depth of Binary Tree
- [ ] 🟢 333. Largest BST Subtree

#### 4. LCA
- [x] 🔵 236. Lowest Common Ancestor of a Binary Tree
- [x] 🟢 235. Lowest Common Ancestor of a Binary Search Tree
- [ ] 🔵 1650. Lowest Common Ancestor of a Binary Tree III

#### 5. Tree Type
- [x] 🔵 98. Validate Binary Search Tree
- [ ] 🔵 100. Same Tree
- [x] 🔵 101. Symmetric Tree
- [x] 🔵 110. Balanced Binary Tree

#### 6. Path
- [ ] 🔵 112. Path Sum
- [ ] 🔵 113. Path Sum II
- [ ] 🔵 124. Binary Tree Maximum Path Sum
- [ ] 🟢 298. Binary Tree Longest Consecutive Sequence
- [ ] 🟢 549. Binary Tree Longest Consecutive Sequence II

#### 7. Others
- [ ] 🔵 199. Binary Tree Right Side View
- [ ] 🔵 513. Find Bottom Left Tree Value
- [ ] 🔵 331. Verify Preorder Serialization of a Binary Tree
- [ ] 🔵 449. Serialize and Deserialize BST
- [ ] 🟢 114. Flatten Binary Tree to Linked List

### DFS
#### 1. Combinations/Permutations

#### 2. Binary Tree
- [x] 🔵 113. Path Sum II
- [x] 🔵 257. Binary Tree Paths
- [ ] 🔵 Lint-246. Binary Tree Path Sum II
- [ ] 🔵 Lint-376. Binary Tree Path Sum
- [ ] 🔵 Lint-472. Binary Tree Path Sum III

#### 3. Graph
- [x] 🔵 547. Number of Provinces
- [ ] 🔵 140. Word Break II
- [ ] 🔵 494. Target Sum
- [ ] 🔵 1192. Critical Connections is a Network
- [ ] 🟢 12. Word Ladder II
- [ ] 🟢 290. Word Pattern
- [ ] 🟢 291. Word Pattern II

### Data Structures
#### 1. Array & Matrix

#### 2. Linked List

#### 3. String

#### 4. Hash

#### 5. Stack

#### 6. Union Find

#### 7. Sweep Line

#### 8. Complex Data Structure

#### 9. Heap

#### 10. Monotonic Stack

#### 11. Trie

#### 12. Binary Index Tree & Segment Tree

### Dynamic Programming
#### 1. Backpack

#### 2. Single Sequence

#### 3. Double Sequences

#### 4. Sections

#### 5. Matrix

#### 6. Greedy

#### 7. Others

# II. Data Structure and Algorithms
## Important Concepts
- [Recurison in Programming (freeCodeCamp)](https://www.youtube.com/watch?v=IJDJ0kBx2LM)
- [Big O Notation(freeCodeCamp)](https://www.youtube.com/watch?v=Mo4vesaut8g&t=784s)

### Data Structure
- Trie
- Heap/Priority Queue
- Union Find
- LinkedList
- Comparator
- LRU
- LFU
- Tree

## Algorithms
- [Binary Search](#binary_search)
- Pointer
- Sliding Window
- BFS
- DFS
- Backtracking
- Merge Sort
- Quick Sort
- Bucket Sort
- Monotonic Stack
- Monotonic Queue
- 扫描线
- Divide and Conquer
- Bit Manipulation
- Prefix Sum
- Dynamic Programming


## Binary Search <span id = "binary_search"></span>
#### 1) How does it work?
n its simplest form, Binary Search operates on a contiguous sequence with a specified left and right index. This is called the Search Space. Binary Search maintains the left, right, and middle indicies of the search space and compares the search target or applies the search condition to the middle value of the collection; if the condition is unsatisfied or values unequal, the half in which the target cannot lie is eliminated and the search continues on the remaining half until it is successful. If the search ends with an empty half, the condition cannot be fulfilled and target is not found.

In the following chapters, we will review how to identify Binary Search problems, reasons why we use Binary Search, and the 3 different Binary Search templates that you might be previously unaware of. Since Binary Search is a common interview topic, we will also categorize practice problems to different templates so you can practice using each.

#### 2) Template
Template #1 is the most basic and elementary form of Binary Search. It is the standard Binary Search Template that most high schools or universities use when they first teach students computer science. Template #1 is used to search for an element or condition which can be determined by accessing a single index in the array.

**Distinguishing Syntax**
* Initial Condition: `left = 0, right = length-1`
* Termination: `left > right`
* Searching Left: `right = mid-1`
* Searching Right: `left = mid+1`

**Implementation**
```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  // End Condition: left > right
  return -1;
}
```

## Union Find | Disjoint Sets
#### 1) what is union find?
[Reference](https://github.com/ryancheunggit/leetcode/blob/rise/note/union_find.md)
* Union Find is a data structure keeps track of a set of elements that are partitioned into a number of disjoint subsets.
* It has two operations `union(p, q)` and `find(p)`.
    * the __find/search__ finds the subset element p belongs to.
    * and __union/merge__ merges the subsets containing p and q.
* It memory usage is __O(N)__, and each find and union operations are near __O(1)__ in time.
* The algorithm can be used to find all connected components in a network.
* It is also used in kruskal's algorithm to find the minimal spanning tree for a graph.

## Binary Tree
#### 1) Inorder (left -> root -> right)
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

#### 2) Preorder (root -> left -> right; iterative investigate root.right then root.left)
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

#### 3) Postorder (left -> right -> root)
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

#### 4) Level order
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
## Merge Sort
#### 1) Intuition
There are two approaches to implement the merge sort algorithm: top down or bottom up. Here, we will explain the top down approach as it can be implemented naturally using recursion.

The merge sort algorithm can be divided into three steps, like all divide-and-conquer algorithms:

```
1. Divide the given unsorted list into several sublists.  (Divide)
2. Sort each of the sublists recursively.  (Conquer)
3. Merge the sorted sublists to produce new sorted list.  (Combine)
```

#### 2) Top-Down Approach
Let us look at a concrete example to see how the top-down merge sort algorithm works. As shown in the figure below, we are given an unordered list with 8 elements. The task is to sort the list in ascending order. 

![alt text](https://assets.leetcode.com/uploads/2019/04/15/topdown_mergesort.png)

```
1. In the first step, we divide the list into two sublists.  (Divide)
2. Then in the next step, we recursively sort the sublists in the previous step.  (Conquer)
3. Finally we merge the sorted sublists in the above step repeatedly to 
obtain the final list of sorted elements.  (Combine)
```

The recursion in step (2) would reach the base case where the input list is either empty or contains a single element (see the nodes in blue from the above figure).

Now, we have reduced the problem down to a merge problem, which is much simpler to solve. Merging two sorted lists can be done in **linear time complexity O(N)**, where N is the total lengths of the two lists to merge.


![Alt Text](https://assets.leetcode.com/uploads/2019/04/06/merge_sort_merge.gif)

```java
import java.util.Arrays;
public class Solution {
    
    public int [] merge_sort(int [] input) {
      if (input.length <= 1) {
        return input;
      }
      int pivot = input.length / 2;
      int [] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
      int [] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
      return merge(left_list, right_list);
    }
    
    public int [] merge(int [] left_list, int [] right_list) {
      int [] ret = new int[left_list.length + right_list.length];
      int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

      while (left_cursor < left_list.length && 
             right_cursor < right_list.length) {
        if (left_list[left_cursor] < right_list[right_cursor]) {
          ret[ret_cursor++] = left_list[left_cursor++];
        } else {
          ret[ret_cursor++] = right_list[right_cursor++];
        }
      }
      // append what is remain the above lists
      while (left_cursor < left_list.length) {
        ret[ret_cursor++] = left_list[left_cursor++];
      }
      while (right_cursor < right_list.length) {
        ret[ret_cursor++] = right_list[right_cursor++];
      }  
      return ret;
    }
}
```
#### 3) Bottom-Up Approach

In the bottom up approach, we divide the list into sublists of a single element at the beginning. Each of the sublists is then sorted already. Then from this point on, we merge the sublists two at a time until a single list remains.

![alt text](https://assets.leetcode.com/uploads/2019/04/06/mergesort.png)

The overall time complexity of the merge sort algorithm is **O(NlogN)**, where *N* is the length of the input list. To calculate the complexity, we break it down to the following steps:

```
1. We recursively divide the input list into two sublists, until a sublist with single element remains. 
This dividing step computes the midpoint of each of the sublists, which takes O(1) time. 
This step is repeated N times until a single element remains, therefore the total time complexity is O(N).
2. Then, we repetitively merge the sublists, until one single list remains. 
The recursion tree in Fig. 1 or Fig. 2 above is useful for visualizing how the recurrence is iterated. 
As shown in the recursion tree, there are a total of N elements on each level. 
Therefore, it takes O(N) time for the merging process to complete on each level. 
And since there are a total of logN levels, the overall complexity of the merge process is O(NlogN).
```

Taking into account the complexity of the above two parts in the merge sort algorithm, we conclude that the overall time complexity of merge sort is **O(NlogN)**.

The space complexity of the merge sort algorithm is **O(N)**, where *N* is the length of the input list, since we need to keep the sublists as well as the buffer to hold the merge results at each round of merge process.

## Divide and Conquer
#### 1) What is divide and conquer?

A divide-and-conquer algorithm works by recursively breaking the problem down into two or more subproblems of the same or related type, until these subproblems become simple enough to be solved directly. Then one combines the results of subproblems to form the final solution.

As you can see, divide-and-conquer algorithm is naturally implemented in the form of recursion. Another subtle difference that tells a divide-and-conquer algorithm apart from other recursive algorithms is that we break the problem down into **two or more** subproblems in the divide-and-conquer algorithm, rather than a single smaller subproblem. The latter recursive algorithm sometimes is called **decrease and conquer** instead, such as **Binary Search**.

There are in general three steps that one can follow in order to solve the problem in a divide-and-conquer manner.

```
1. Divide. Divide the problem S into a set of subproblems: S_1, S_2, ... S_n where n≥2.
2. Conquer. Solve each subproblem recursively. 
3. Combine. Combine the results of each subproblem.
```

![alt text](https://assets.leetcode.com/uploads/2019/04/24/d_c.png)

#### 2) Template

```python
def divide_and_conquer( S ):
    # (1). Divide the problem into a set of subproblems.
    [S1, S2, ... Sn] = divide(S)

    # (2). Solve the subproblem recursively,
    #   obtain the results of subproblems as [R1, R2... Rn].
    rets = [divide_and_conquer(Si) for Si in [S1, S2, ... Sn]]
    [R1, R2,... Rn] = rets

    # (3). combine the results from the subproblems.
    #   and return the combined result.
    return combine([R1, R2,... Rn])
```

As one can see from the above template, the essential part of the divide and conquer is to figure out the `recurrence relationship` between the subproblems and the original problem, which subsequently defines the functions of `divide()` and `combine()`. 

#### 3) Examples
#### a) Validate Binary Search Tree
Sometimes, tree related problems can be solved using divide-and-conquer algorithms.

Given a binary tree, validate if the given tree is a binary search tree (BST). The BST must meet all of the following properties:

```
All values on the left subtree of a node should be less than the value of the node.
All values on the right subtree of a node should be greater than the value of the node.
Both the left and right subtrees must also be binary search trees.
```

Read point **no.3** above very carefully. The definition of BST is recursive in nature, making this a natural divide and conquer problem.
Below is an example of a BST shown in the following figure.
![alt text](https://assets.leetcode.com/uploads/2019/03/31/bst_dac.png)

```
1. In the first step, we divide the tree into two subtrees -- its left child and right child. (Divide)
2. Then in the next step, we recursively validate each subtree is indeed a binary search tree. (Conquer)
3. Upon the results of the subproblems from Step 2, we return true if and only if both subtrees are both valid BST. (Combine)
```

The recursion in **Step 2**. would reach the base case where the subtree is either empty or contains a single node, which is a valid BST itself.

#### b) Search in A 2D Matrix

Write an efficient algorithm that searches for an integer value in an *mn* matrix. This matrix has the following properties:
```
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
```

There are several ways to solve the above problem. Here we give an overall idea to solve it in the divide-and-conquer manner. 
As one might notice, given the matrix, if we divide it into some sub-matrices by cutting it either by row and/or column, the resulting matrices would still keep the above two properties of the original matrix. Given the above insight, here is how we can apply the template to solve the problem.

```
1. We divide the matrix into 4 sub-matrices by choosing a pivot point based on a row and a column. (Divide)
2. Then we recursively look into each sub-matrix to search for the desired target. (Conquer)
3. If we find the target in either of the sub-matrices, we stop the search and 
return the result immediately. (Combine)
```

The base cases in the above recursion would be either the input matrix is empty or it contains only a single element. As a simple strategy, one can choose the middle point both on the row and column as the pivot points to divide the matrix.

Do we really need to look into each of the divided 4 sub-matrices? Notice that the smallest and the largest element of the input matrix is located in the top left and bottom right corner respectively, which also applies to each of the divided sub-matrices. In fact, we need to only look into 3 of the sub-matrices.

```
1. If our target is equal to the pivot, we have found our target and immediately return the result.
2. If our target is less than the pivot, we can discard the bottom-right sub-matrix. 
All elements in that region must be greater or equal than the pivot.
3. If our target is greater than the pivot, we can discard the top-left sub-matrix. 
All elements in that region must be less than or equal than the pivot.
```

The above divide-and-conquer algorithm can still be further improved, which we will provide insights below.

**As an improvement to the above divide-and-conquer algorithm, we could devise a better strategy by choosing the pivot points wisely.**

We illustrate a strategy in the following figure, to reduce the search zones into 2 sub-matrices, instead of 3 sub-matrices.
![alt text](https://assets.leetcode.com/uploads/2019/03/31/search_2d_matrix.png)

First, we choose the middle point on the column which divides the matrix into two sub-matrices. We then fix on this middle column to further determine an optimal row to divide the matrix. We scan the elements along the chosen middle column, to locate the boundary where the value of the element just goes beyond the target value, i.e. *V_i-1 < target < V_i*. From this point, we divide the original matrix into 4 sub-matrices. And we just need to zoom into the bottom left and top right sub-matrices to look for the target value, while ignoring the top left and bottom right sub-matrices.

We ignore the top left sub-matrix that ends with the element *V_i-1*, because all the elements within this sub-matrix would be less than the target value. Similarly, we ignore the bottom right sub-matrices that starts with the element *V_i*, because we know that all the elements within this sub-matrix would be greater than the target value.

## Quick Sort
#### 1) Intuition
Following the pseudocode template of the divide-and-conquer algorithm, as we presented before, the quick sort algorithm can be implemented in three steps, namely dividing the problem, solving the subproblems and combining the results of subproblems.

In detail, given a list of values to sort, the quick sort algorithm works in the following steps:
```
1. First, it selects a value from the list, which serves as a pivot value to divide the list into two sublists. One sublist contains all the values that are less than the pivot value, while the other sublist contains the values that are greater than or equal to the pivot value. This process is also called partitioning. The strategy of choosing a pivot value can vary. Typically, one can choose the first element in the list as the pivot, or randomly pick an element from the list.

2. After the partitioning process, the original list is then reduced into two smaller sublists. We then recursively sort the two sublists.

3. After the partitioning process, we are sure that all elements in one sublist are less or equal than any element in another sublist. Therefore, we can simply concatenate the two sorted sublists that we obtain in step [2] to obtain the final sorted list. 
```
The base cases of the recursion in step [2] are either when the input list is empty or the empty list contains only a single element. In either case, the input list can be considered as sorted already.

As one can see, the essential idea of the quick sort algorithm is the `partitioning process`, which elegantly reduces the problems into smaller scale and meanwhile moves towards the final solution, i.e. after each partitioning, the overall values become more ordered. 

#### 2) Algorithm
In the following figure, we demonstrate how the quick sort algorithm works to sort a list of integer values. The input list contains 8 elements.
![alt text](https://assets.leetcode.com/uploads/2019/03/24/quicksort.png)

As shown above, in the first round of quick sort, we pick the last element `4` as the `pivot`, which partitions the original list into two sublists: `[1, 3, 2]` and `[8, 7, 6, 5]` respectively.

Next, we recursively sort the above two sublists. For instance, for the sublist `[1, 3, 2]`, again we pick the last element (i.e. 2) as the pivot value. After this partitioning, we obtain two sublists with a single element, which is the base case of the recursion.

Once we sorted the sublists `[1, 3, 2]` and `[8, 7, 6, 5]` respectively, we simply concatenate the sorted results together with the pivot value (4) to form the final result, i.e. `[1, 2, 3] + [4] + [5, 6, 7, 8]`.

#### 3) Template
```java
public class Solution {

  public void quickSort(int [] list) {
   /* Sorts an array in the ascending order in O(n log n) time */
    int n = list.length;
    qSort(list, 0, n - 1);
  }

  private void qSort(int [] list, int low, int high) {
    if (low < high) {
      int p = partition(lst, low, hi);
      qSort(list, low, p - 1);
      qSort(list, p + 1, high);
    }
  }

  private int partition(int [] list, int low, int high) {
    /*
      Picks the last element high as a pivot
      and returns the index of pivot value in the sorted array */
    int pivot = list[high];
    int i = low;
    for (int j = low; j < high; ++j) {
      if (list[j] < pivot) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
        i++;
      }
    }
    int tmp = list[i];
    list[i] = list[high];
    list[hi] = tmp;
    return i;
  }
}
```
#### 4) Complexity
Depending on the pivot values, the time complexity of the quick sort algorithm can vary from *O(NlogN)* in the best case and *O(N^2)* in the worst case, with *N* as the length of the list.

In the best case, if the pivot value happens to be median value of the list, then at each partition the list would be divided into two sublists of equal size. At the end, we actually construct a balanced binary search tree (BST) out of the list. One can infer that the height of the tree would be *logN*, and at each level of the tree the input list would be scanned once with the complexity *O(N)* due to the partitioning process. As a result, the overall time complexity of the algorithm in this case would be *O(NlogN)*.

While in the worst case, if the pivot value happens to be the extreme value of the list, i.e. either the smallest or the biggest element in the list, then at each partition we end up with only one single sublist (i.e. the other sublist is empty). The reduction of the problem still works, but at a rather slow pace, i.e. one element at a time. The partitioning would then occur *N* times, and each time the partitioning scans at most *N* elements. Therefore, the overall time complexity of the quick sort algorithm in this case would be *O(N^2)*. Actually, in this case, the quick sort algorithm ends up to be exactly as the insertion sort.

On average, as proved mathematically, the time complexity of quick sort is *O(NlogN)*.  

