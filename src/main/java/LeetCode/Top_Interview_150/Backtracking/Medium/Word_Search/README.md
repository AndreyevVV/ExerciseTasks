---
created: 2023-12-09T19:26:55 (UTC +01:00)
source: https://leetcode.com/problems/word-search/?envType=study-plan-v2&envId=top-interview-150
---
Given an `m x n` grid of characters `board` and a string `word`, return `true` _if_ `word` _exists in the grid_.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

**Example 1:**

![img.png](img.png)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
```

**Example 2:**

![img_1.png](img_1.png)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
```

**Example 3:**

![img_2.png](img_2.png)

```
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
```

**Constraints:**

-   `m == board.length`
-   `n = board[i].length`
-   `1 <= m, n <= 6`
-   `1 <= word.length <= 15`
-   `board` and `word` consists of only lowercase and uppercase English letters.

**Follow up:** Could you use search pruning to make your solution faster with a larger `board`?
