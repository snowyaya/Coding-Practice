
### LeetCode-Practice-Explanation
This table is the record of the LeetCode problems I have solved and the link to my video explanation is also attached.
| Problem |Type | Video | What did you miss? why? | Useful resources | Revisit |
| --- | --- | --- | --- | --- | --- |
| 323 | Union Find, DFS| [Number of Connected Components in Undirected Graph](https://drive.google.com/file/d/1dKj-ISvLeD69cJVjl5_ZdPD2QITQbrsd/view?usp=sharing) |
| 200 | Union Find, DFS | [Number of Islands](https://drive.google.com/file/d/1PBQnNPi5V-EglKhyLyTUKlEKboPDhh1Q/view?usp=sharing) |
| 232 | Queue, Stack | [Implement Queue with Stacks](https://drive.google.com/file/d/1XSxYgV1y920T3BhwJ2wRg2IVyl9mATUu/view?usp=sharing) |
| 236 | Binary Tree| [Lowest Common Ancestor of a Binary Tree: part1](https://drive.google.com/file/d/1UpiVikwsjdzRJhoi3R5qLqmQjDUgcO2E/view?usp=sharing) [part2](https://drive.google.com/file/d/1rM6KERa6JoJCmSFzDg3hHFcME7dqGs0O/view?usp=sharing)|
| 56 | Pointer, Interval | [Merge Intervals](https://drive.google.com/file/d/1da-Sk9Umm4WeYN4bsMW_WsUE_1CHO2aQ/view?usp=sharing) | sort 2D array by the first value of nested array:<br /> ```Arrays.sort(intervals, (array1, array2) -> Integer.compare(array1[0], array2[0]))```;<br /> convert a list of array to a 2D array:<br /> ```list.toArray(new int[list.size()][])```;| [Why do we use Lamda](https://www.programcreek.com/2014/01/why-lambda-java-8/)<br /> [Deep understanding of Arrays.sort()](https://www.programcreek.com/2013/11/arrays-sort-comparator/)<br /> [5 different Lamda expression](https://www.programcreek.com/2014/01/5-different-syntax-of-lambda-expression/)<br /> |
| 102 | Binary Tree | Level Order Traversal |
| 94 | Binary Tree | Inorder Traversal |
| 144 | Binary Tree | Preorder Traversal | If use iteration, investigate root.right before root.left because of using stack |
| 145 | Binary Tree | Postorder Traversal |
| [102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Binary Tree | Level Order Traversal |
| 344 | String, Recursion | Reverse String |
| [24](https://leetcode.com/problems/swap-nodes-in-pairs/) | LinkedList, Recursion | Swap Nodes in Pairs | When using iteration, use a node temp, a node node, a node prev; remember the head is updated out of the while loop. |
| [206](https://leetcode.com/problems/reverse-linked-list/) | LinkedList, Recursion | Reverse Linked List | 
| [700](https://leetcode.com/problems/search-in-a-binary-search-tree/) | BST, Recursion | Search in a Binary Search Tree |
| [119](https://leetcode.com/problems/pascals-triangle-ii/) | Array, Recursion | Pascal's Triangle II |
| [70](https://leetcode.com/problems/climbing-stairs/) | Array, Recursion | Climb Stairs |
| [104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Binary Tree, Recursion | Maximum Depth of a Binary Tree |
| [50](https://leetcode.com/problems/powx-n/) | Math, Recursion | Pow(x, n) | 1) when power < 0 <br/> 2) if n%2 == 0, binary product |
| [21](https://leetcode.com/problems/merge-two-sorted-lists/) | LinkedList, Recursion | Merge Two Sorted Lists | 
| [912](https://leetcode.com/problems/sort-an-array/) | Array, Merge Sort, Divide and Conquer | Sort An Array | 1) Append remaining list in the end <br/> 2) Use ```Arrays.copyOfRange(arr, start, end)``` <br/> 3) When initialize the result array ```int[] result = new int[left.length + right.length];``` |
| [98](https://leetcode.com/problems/validate-binary-search-tree/) | Binary Search Tree, Divide and Conquer | Validate Binary Search Tree | | [Check if a binary tree is BST](https://www.youtube.com/watch?v=MILxfAbIhrE) <br/> [Image illustration](https://leetcode.com/problems/validate-binary-search-tree/discuss/229282/Neat-Java-Recursive-Solution)|
| [240](https://leetcode.com/problems/search-a-2d-matrix-ii/) | Array, Divide and Conquer | Search in 2D Array | 1) Discard the bottom right if `target < pivot` <br/> 2) Discard top left if `target > pivot` |
| [100](https://leetcode.com/problems/same-tree/) | Binary Tree, Recursion-Iteration | Same Tree | 
|[744](https://leetcode.com/problems/find-pivot-index/) | Array, Dynamic Programming | Find Pivot Index |
| [747](https://leetcode.com/problems/largest-number-at-least-twice-of-others/) | Array, Sorting | Largest Number At Least Twice of Others | 
| [66](https://leetcode.com/problems/plus-one/) | Array, Math | Plus One | 1) Edge case like 9999, just do `int[] newNumber = new int[n+1]` and `newNumber[0] = 0` <br/> 2) Loop down from length - 1, if `digit[i] < 9`, `digits[i]++`; if `digits[i] == 9`, `digits[i] = 0`. |
| [498](https://leetcode.com/problems/diagonal-traverse/) | 2D Array | Diagonal Traversal |
| [118](https://leetcode.com/problems/pascals-triangle/) | Array | Pascal's Triangle | 1) had two base cases `return list.add(1) and return list.add (1,1)`, but the starting row never returns, because the `return list.add(1,1)` is the base case when rowIndx > 1. So the starting row is always missing in the map |
| [67](https://leetcode.com/problems/add-binary/) | String | Add Binary | Don't know how to when to carry and chang the digit <br/> Not sure whether to use `char[]` or `String` or `int[]` | [Other's explanation](https://leetcode.com/problems/add-binary/discuss/190723/5ms-Java-solution-with-explanation-of-code-and-binary-adding.) |
| [9](https://leetcode.com/problems/palindrome-number/) | Array | Palindrome Number | 
| [15](https://leetcode.com/problems/3sum/) | Array | 3Sum |
| [28](https://leetcode.com/problems/implement-strstr/) | String | Implement strStr() | 1) `while (i+lenOfNeedle <= haystack)` |
| [14](https://leetcode.com/problems/longest-common-prefix/) | String | Longest Common Prefix | 1) use `StringBuilder` <br/> 2) `strb.append(str)` <br/> 3) sort the array at the beginning <br/> 4) `strb.toString()` |
| [561](https://leetcode.com/problems/array-partition-i/) | Array | Array Partition |
| [217](https://leetcode.com/problems/contains-duplicate/) | Array, Hash Table | Contains Duplicates |
| [53](https://leetcode.com/problems/maximum-subarray/) | Array | Max Subarray |
| [88](https://leetcode.com/problems/merge-sorted-array/) | Array | Merge Sorted Array | 1) set pointers to the end of the array <br/> 2) compare from the back of the array<br/> 3) 3 pointers|
| [167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Array | Two Sum II: Input Arrays is Sorted | 1) use two pointers: `low` and `high` |
| [27](https://leetcode.com/problems/remove-element/) | Array | Remove Element | 1) two pointers <br/> 2) swap the values if `nums[left] == val` and if `nums[right] != val` then `nums[left] = nums[right]` |
| [485](https://leetcode.com/problems/max-consecutive-ones/) | Array | Max Consecutive Ones | 1) How to improve the time complexity? <br/> |
| [151](https://leetcode.com/problems/reverse-words-in-a-string/) | String | Reverse Words in A String | 1) Be careful with multiple whitespace <br/> 2) Be careful with adding a whitespace in the end, use `if map.get(i-1) != null` <br/> 3) Iterate the array from the end is easier |
| [557](https://leetcode.com/problems/reverse-words-in-a-string-iii/) | String | Reverse Words in A String III | 1) Be careful with the ending whitespace <br/> 2) Use `int i = 0` to iterate over the `string array` |
| [283](https://leetcode.com/problems/move-zeroes/) | Array | Move Zeroes | 1) Update `nums[count++]` to the `non-zero element`, then update `nums[count++]` to `zero` |
| [209](https://leetcode.com/problems/minimum-size-subarray-sum/) | Array | Minimum Size Array Sum | 1) If `sum >= target`, update the `min`, update the sum `sum = sum - nums[ptr1] - nums[ptr2]` |
| [189](https://leetcode.com/problems/rotate-array/) | Array | Rotate Array | 1) Use `O(n)` to figure out how the position of each element changes |
| [26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Array | Remove Duplicates from Sorted Array | 1) one pointer for the current element, another for the next unique element <br/> 2) Update `curr += 1`, then `nums[curr] = nums[i]` |
| [498](https://leetcode.com/problems/diagonal-traverse/) | Array | Diagonal Traverse | Key Observation : If you write down the matrix in terms of the indices, you will notice that whenever the indices add to an even number, we go in the upward direction, else in the downward direction. |
| [54](https://leetcode.com/problems/spiral-matrix/) | Array | Spiral Matrix | 
| [36](https://leetcode.com/problems/valid-sudoku/) | Array | Valid Sudoku | 
| [74](https://leetcode.com/problems/search-a-2d-matrix/) | Array | Seach A 2D Matrix |
| [387](https://leetcode.com/problems/first-unique-character-in-a-string/) | String | First Unique Character in A String | 1) `LinkedHashMap` store element in the insertion order |
| [383](https://leetcode.com/problems/ransom-note/) | String | Ransom Note | 
| [242](https://leetcode.com/problems/valid-anagram/) | String | Valid Anagram |
| [141](https://leetcode.com/problems/linked-list-cycle/) | Linked List | Linked List Cycle |
| [21](https://leetcode.com/problems/merge-two-sorted-lists/) | Linked List | Merge Two Sorted Lists | 1) if `l1.val < l2.val`, `l1.next = mergeTwoLists(l1.next, l2)`; if `l1.val >= l2.val`, `l2.next = mergeTwoLists(l1, l2.next)`; |
| [203](https://leetcode.com/problems/remove-linked-list-elements/) | Linked List | Remove Linked List Elements | 1) `ListNode dummyHead = new ListNode(0)`; <br/> `dummyHead.next = head`; <br/> `ListNode prev = dummyHead`, <br/> `curr = head`; <br/> 2) return `dummyHead.next` |
| [83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) | Linked List | Remove Duplicates from Sorted Lists | 1) Use a `curr` pointer to keep track of the value and its next value <br/> 2) `while (curr != null && curr.next != null)` |
| [105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Binary Tree | Construct Binary Tree from Preorder and Inorder Traversal | | 1) [recursive with picture](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/683377/Java-with-Picture) |
| [106](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | Binary Tree | Construct Binary Tree from Inorder and Postorder Traversal |
| [69](https://leetcode.com/problems/sqrtx/) | Binary Search | Sqrt(x) | 1) `0 < res < x/ 2` |
| [317](https://leetcode.com/problems/guess-number-higher-or-lower/) | Binary Search | Guess Number higher or Lower |
| [33](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Binary Search | Search in Rotated Array |
| [278](https://leetcode.com/problems/first-bad-version/) | Binary Search | First Bad Version |
| [162](https://leetcode.com/problems/find-peak-element/) | Binary Search | Find Peak Element |
| [153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Binary Search | Find Minimum in Rotated Array |
| [34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | Binary Search | Find First and Last Position of Element in Sorted Array |
| [658](https://leetcode.com/problems/find-k-closest-elements/) | Binary Search | Find k Closest elements |
| [270](https://leetcode.com/problems/closest-binary-search-tree-value/) | Binary Search | Closest Binary Search Tree Value | | | :yellow_circle:9/15/21 |
| [367](https://leetcode.com/problems/valid-perfect-square/) | Binary Search | Valid Perfect Square | 1) use `long` type to avoid 2147483647 case | | :yellow_circle:9/15/21 |
| [702](https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/) | Binary Search | Seach in a Sorted Unknown Size Array | | | :green_circle:9/15/21 |
| [744](https://leetcode.com/problems/find-smallest-letter-greater-than-target/) | Binary Search | Find Smallest Letter Greater Than Target | 1) find the rightmost position to insert target into letters so that it remains sorted. <br/> 2) return `letters[left % letters.length]` |  | :red_circle:9/16/21 |
| [154](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/) | Binary Search | Find Minimum in Roated Array II | 1) When `nums[mid] == nums[right]`, update the `right -= 1`<br/> 2) return `nums[left]` at the end | 1) [watch](youtube.com/watch?v=K0PjrikGKK4&t=236s) at 5:00 <br/> 2) ![img](https://github.com/snowyaya/LeetCode-Daily-Practice/blob/master/images/154.png) | :red_circle:9/16/21 |
| [349](https://leetcode.com/problems/intersection-of-two-arrays/) | Binary Search | Intersection of Two Arrays | 1) intersection is unique | 1) ![img](https://github.com/snowyaya/LeetCode-Daily-Practice/blob/master/images/349.png) | :red_circle:9/16/21|
| [350](https://leetcode.com/problems/intersection-of-two-arrays-ii/) | Binary Search | Intersection of Two Arrays II | 1) use `hashmap` to the short array integers <br/> 2) decrement `k` if `num : nums2` in the map <br/> 3) intersection is unique | 1)![img](https://github.com/snowyaya/LeetCode-Daily-Practice/blob/master/images/350.png) | :red_circle:9/16/21 |
| [455](https://leetcode.com/problems/assign-cookies/) | Greedy | Assign Cookies | 1) `sort` both children greedy factors and cookies | | 🟢9/25/21 |

