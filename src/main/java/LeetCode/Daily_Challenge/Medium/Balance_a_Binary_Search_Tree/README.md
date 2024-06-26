---
created: 2024-06-26T23:01:15 (UTC +03:00)
source: https://leetcode.com/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2024-06-26
---
Given the `root` of a binary search tree, return _a **balanced** binary search tree with the same node values_. If there is more than one answer, return **any of them**.

A binary search tree is **balanced** if the depth of the two subtrees of every node never differs by more than `1`.


**Example 1:**

![img.png](img.png)

```
Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
```


**Example 2:**

![img_1.png](img_1.png)

```
Input: root = [2,1,3]
Output: [2,1,3]
```


**Constraints:**

-   The number of nodes in the tree is in the range `[1, 10^4]`.
-   `1 <= Node.val <= 10^5`
