---
created: 2025-01-20T16:37:39 (UTC +03:00)
source: https://leetcode.com/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2025-01-20
---
You are given a **0-indexed** integer array `arr`, and an `m x n` integer **matrix** `mat`. `arr` and `mat` both contain **all** the integers in the range `[1, m * n]`.

Go through each index `i` in `arr` starting from index `0` and paint the cell in `mat` containing the integer `arr[i]`.

Return _the smallest index_ `i` _at which either a row or a column will be completely painted in_ `mat`.


**Example 1:**

![img.png](img.png)

``` Java
Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
Output: 2
Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
```


**Example 2:**

![img_1.png](img_1.png)

``` Java
Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
Output: 3
Explanation: The second column becomes fully painted at arr[3].
```


**Constraints:**

-   `m == mat.length`
-   `n = mat[i].length`
-   `arr.length == m * n`
-   `1 <= m, n <= 10^5`
-   `1 <= m * n <= 10^5`
-   `1 <= arr[i], mat[r][c] <= m * n`
-   All the integers of `arr` are **unique**.
-   All the integers of `mat` are **unique**.
