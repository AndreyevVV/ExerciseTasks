---
created: 2023-07-28T19:41:12 (UTC +02:00)
source: https://leetcode.com/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75
---
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a **leaf value sequence**_._

![img.png](img.png)

For example, in the given tree above, the leaf value sequence is `(6, 7, 4, 9, 8)`.

Two binary trees are considered _leaf-similar_ if their leaf value sequence is the same.

Return `true` if and only if the two given trees with head nodes `root1` and `root2` are leaf-similar.

**Example 1:**

![img_1.png](img_1.png)

```
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

```

**Example 2:**

![img_2.png](img_2.png)

```
Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false

```

**Constraints:**

-   The number of nodes in each tree will be in the range `[1, 200]`.
-   Both of the given trees will have values in the range `[0, 200]`.
