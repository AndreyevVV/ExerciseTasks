---
created: 2023-08-21T20:15:21 (UTC +02:00)
source: https://leetcode.com/problems/domino-and-tromino-tiling/?envType=study-plan-v2&envId=leetcode-75
---
You have two types of tiles: a `2 x 1` domino shape and a tromino shape. You may rotate these shapes.

![img.png](img.png)

Given an integer n, return _the number of ways to tile an_ `2 x n` _board_. Since the answer may be very large, return it **modulo** `10^9 + 7`.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

**Example 1:**

![img_1.png](img_1.png)

```
Input: n = 3
Output: 5
Explanation: The five different ways are show above.

```

**Example 2:**

```
Input: n = 1
Output: 1

```

**Constraints:**

-   `1 <= n <= 1000`
