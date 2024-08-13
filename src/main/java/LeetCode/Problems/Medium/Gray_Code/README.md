---
created: 2024-08-13T22:45:22 (UTC +03:00)
source: https://leetcode.com/problems/gray-code/description/
---
An **n-bit gray code sequence** is a sequence of `2^n` integers where:

-   Every integer is in the **inclusive** range `[0, 2^n - 1]`,
-   The first integer is `0`,
-   An integer appears **no more than once** in the sequence,
-   The binary representation of every pair of **adjacent** integers differs by **exactly one bit**, and
-   The binary representation of the **first** and **last** integers differs by **exactly one bit**.

Given an integer `n`, return _any valid **n-bit gray code sequence**_.


**Example 1:**

``` Java
Input: n = 2
Output: [0,1,3,2]
Explanation:
The binary representation of [0,1,3,2] is [00,01,11,10].
- 0_0_ and 0_1_ differ by one bit
- _0_1 and _1_1 differ by one bit
- 1_1_ and 1_0_ differ by one bit
- _1_0 and _0_0 differ by one bit
[0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
- _0_0 and _1_0 differ by one bit
- 1_0_ and 1_1_ differ by one bit
- _1_1 and _0_1 differ by one bit
- 0_1_ and 0_0_ differ by one bit
```


**Example 2:**

``` Java
Input: n = 1
Output: [0,1]
```


**Constraints:**

-   `1 <= n <= 16`
