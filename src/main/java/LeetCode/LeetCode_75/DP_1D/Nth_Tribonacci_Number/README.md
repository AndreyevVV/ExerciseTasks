---
created: 2023-08-21T20:06:39 (UTC +02:00)
source: https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75
---
The Tribonacci sequence T_n is defined as follows: 

T_0 = 0, T_1 = 1, T_2 = 1, and T_n+3 = T_n + T_n+1 + T_n+2 for n >= 0.

Given `n`, return the value of T_n.

**Example 1:**

```
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

```

**Example 2:**

```
Input: n = 25
Output: 1389537

```

**Constraints:**

-   `0 <= n <= 37`
-   The answer is guaranteed to fit within a 32-bit integer, ie. `answer <= 2^31 - 1`.
