---
created: 2024-08-09T22:11:52 (UTC +03:00)
source: https://leetcode.com/problems/magic-squares-in-grid/description/?envType=daily-question&envId=2024-08-09
---
A `3 x 3` **magic square** is a `3 x 3` grid filled with distinct numbers **from** 1 **to** 9 such that each row, column, and both diagonals all have the same sum.

Given a `row x col` `grid` of integers, how many `3 x 3` contiguous magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, `grid` may contain numbers up to 15.


**Example 1:**

![img.png](img.png)

``` Java
Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
Output: 1
Explanation:
The following subgrid is a 3 x 3 magic square:
```

![img_1.png](img_1.png)

```
while this one is not:
```

![img_2.png](img_2.png)

```
In total, there is only one magic square inside the given grid.
```


**Example 2:**

``` Java
Input: grid = [[8]]
Output: 0
```


**Constraints:**

-   `row == grid.length`
-   `col == grid[i].length`
-   `1 <= row, col <= 10`
-   `0 <= grid[i][j] <= 15`
