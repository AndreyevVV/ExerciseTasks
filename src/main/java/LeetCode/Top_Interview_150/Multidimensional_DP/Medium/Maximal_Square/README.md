---
created: 2023-11-26T23:35:19 (UTC +01:00)
source: https://leetcode.com/problems/maximal-square/?envType=study-plan-v2&envId=top-interview-150
---
Given an `m x n` binary `matrix` filled with `0`'s and `1`'s, _find the largest square containing only_ `1`'s _and return its area_.

**Example 1:**

![img.png](img.png)

```
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

```

**Example 2:**

![img_1.png](img_1.png)

```
Input: matrix = [["0","1"],["1","0"]]
Output: 1

```

**Example 3:**

```
Input: matrix = [["0"]]
Output: 0

```

**Constraints:**

-   `m == matrix.length`
-   `n == matrix[i].length`
-   `1 <= m, n <= 300`
-   `matrix[i][j]` is `'0'` or `'1'`.
