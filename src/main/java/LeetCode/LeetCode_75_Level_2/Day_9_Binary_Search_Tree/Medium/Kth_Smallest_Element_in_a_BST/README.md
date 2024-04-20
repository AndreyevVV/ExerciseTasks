---
created: 2023-05-25T22:45:15 (UTC +02:00)
source: https://leetcode.com/problems/kth-smallest-element-in-a-bst/?envType=study-plan&id=level-2
---
Given the `root` of a binary search tree, and an integer `k`, return _the_ `k^th` _smallest value (**1-indexed**) of all the values of the nodes in the tree_.

**Example 1:**

![img.png](img.png)

```
Input: root = [3,1,4,null,2], k = 1
Output: 1

```

**Example 2:**

![img_1.png](img_1.png)

```
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

```

**Constraints:**

-   The number of nodes in the tree is `n`.
-   `1 <= k <= n <= 10^4`
-   `0 <= Node.val <= 10^4`

**Follow up:** If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
