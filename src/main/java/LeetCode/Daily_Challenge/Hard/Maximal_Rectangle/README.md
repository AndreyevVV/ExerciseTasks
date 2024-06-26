---
created: 2024-04-13T22:11:30 (UTC +03:00)
source: https://leetcode.com/problems/maximal-rectangle/description/?envType=daily-question&envId=2024-04-13
---
Given a `rows x cols` binary `matrix` filled with `0`'s and `1`'s, find the largest rectangle containing only `1`'s and return _its area_.


**Example 1:**

![img.png](img.png)

``` Java
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
```


**Example 2:**

``` Java
Input: matrix = [["0"]]
Output: 0
```

**Example 3:**

``` Java
Input: matrix = [["1"]]
Output: 1
```

**Constraints:**

* `rows == matrix.length`
* `cols == matrix[i].length`
* `1 <= row, cols <= 200`
* `matrix[i][j]` is `'0'` or `'1'`.
