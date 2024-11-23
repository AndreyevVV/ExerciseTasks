---
created: 2024-11-23T23:19:05 (UTC +03:00)
source: https://leetcode.com/problems/rotating-the-box/description/?envType=daily-question&envId=2024-11-23
---
You are given an `m x n` matrix of characters `box` representing a side-view of a box. Each cell of the box is one of the following:

-   A stone `'#'`
-   A stationary obstacle `'*'`
-   Empty `'.'`

The box is rotated **90 degrees clockwise**, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity **does not** affect the obstacles' positions, and the inertia from the box's rotation **does not** affect the stones' horizontal positions.

It is **guaranteed** that each stone in `box` rests on an obstacle, another stone, or the bottom of the box.

Return _an_ `n x m` _matrix representing the box after the rotation described above_.


**Example 1:**

![img.png](img.png)

``` Java
Input: box = [["#",".","#"]]
Output: [["."],
        ["#"],
        ["#"]]
```


**Example 2:**

![img_1.png](img_1.png)

``` Java
Input: box = [["#",".","*","."],
             ["#","#","*","."]]
Output: [["#","."],
        ["#","#"],
        ["*","*"],
        [".","."]]
```


**Example 3:**

![img_2.png](img_2.png)

``` Java
Input: box = [["#","#","*",".","*","."],
             ["#","#","#","*",".","."],
             ["#","#","#",".","#","."]]
Output: [[".","#","#"],
        [".","#","#"],
        ["#","#","*"],
        ["#","*","."],
        ["#",".","*"],
        ["#",".","."]]
```


**Constraints:**

-   `m == box.length`
-   `n == box[i].length`
-   `1 <= m, n <= 500`
-   `box[i][j]` is either `'#'`, `'*'`, or `'.'`.
