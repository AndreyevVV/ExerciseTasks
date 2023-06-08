---
created: 2023-06-07T23:09:40 (UTC +02:00)
source: https://leetcode.com/problems/same-tree/?envType=study-plan&envId=level-2&plan=leetcode-75
---
Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

**Example 1:**

![img.png](img.png)

```
Input: p = [1,2,3], q = [1,2,3]
Output: true

```

**Example 2:**

![img_1.png](img_1.png)

```
Input: p = [1,2], q = [1,null,2]
Output: false

```

**Example 3:**

![img_2.png](img_2.png)

```
Input: p = [1,2,1], q = [1,1,2]
Output: false

```

**Constraints:**

-   The number of nodes in both trees is in the range `[0, 100]`.
-   `-10^4 <= Node.val <= 10^4`
