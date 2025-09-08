---
created: 2025-09-08T16:00:10 (UTC +03:00)
source: https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/?envType=daily-question&envId=2025-09-08
---
**No-Zero integer** is a positive integer that **does not contain any `0`** in its decimal representation.

Given an integer `n`, return _a list of two integers_ `[a, b]` _where_:

-   `a` and `b` are **No-Zero integers**.
-   `a + b = n`

The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.


**Example 1:**

``` Java
Input: n = 2
Output: [1,1]
Explanation: Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.
```


**Example 2:**

``` Java
Input: n = 11
Output: [2,9]
Explanation: Let a = 2 and b = 9.
Both a and b are no-zero integers, and a + b = 11 = n.
Note that there are other valid answers as [8, 3] that can be accepted.
```


**Constraints:**

-   `2 <= n <= 10^4`
