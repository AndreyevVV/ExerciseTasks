---
created: 2024-08-10T23:08:45 (UTC +03:00)
source: https://leetcode.com/problems/regions-cut-by-slashes/description/?envType=daily-question&envId=2024-08-10
---
An `n x n` grid is composed of `1 x 1` squares where each `1 x 1` square consists of a `'/'`, `'\'`, or blank space `' '`. These characters divide the square into contiguous regions.

Given the grid `grid` represented as a string array, return _the number of regions_.

Note that backslash characters are escaped, so a `'\'` is represented as `'\\'`.


**Example 1:**

![img.png](img.png)

``` Java
Input: grid = [" /","/ "]
Output: 2
```


**Example 2:**

![img_1.png](img_1.png)

``` Java
Input: grid = [" /","  "]
Output: 1
```


**Example 3:**

![img_2.png](img_2.png)

``` Java
Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
```


**Constraints:**

-   `n == grid.length == grid[i].length`
-   `1 <= n <= 30`
-   `grid[i][j]` is either `'/'`, `'\'`, or `' '`.
