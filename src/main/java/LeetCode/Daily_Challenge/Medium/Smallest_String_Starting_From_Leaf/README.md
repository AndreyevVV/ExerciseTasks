---
created: 2024-04-17T21:32:00 (UTC +03:00)
source: https://leetcode.com/problems/smallest-string-starting-from-leaf/description/?envType=daily-question&envId=2024-04-17
---
You are given the `root` of a binary tree where each node has a value in the range `[0, 25]` representing the letters `'a'` to `'z'`.

Return _the **lexicographically smallest** string that starts at a leaf of this tree and ends at the root_.

As a reminder, any shorter prefix of a string is **lexicographically smaller**.

-   For example, `"ab"` is lexicographically smaller than `"aba"`.

A leaf of a node is a node that has no children.


**Example 1:**

![img.png](img.png)

``` Java
Input: root = [0,1,2,3,4,3,4]
Output: "dba"
```


**Example 2:**

![img_1.png](img_1.png)

``` Java
Input: root = [25,1,3,1,3,0,2]
Output: "adz"
```


**Example 3:**

![img_2.png](img_2.png)

``` Java
Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"
```


**Constraints:**

-   The number of nodes in the tree is in the range `[1, 8500]`.
-   `0 <= Node.val <= 25`
