---
created: 2025-03-04T07:26:57 (UTC +03:00)
source: https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/?envType=daily-question&envId=2025-03-04
---
Given an integer `n`, return `true` _if it is possible to represent_ `n` _as the sum of distinct powers of three._ Otherwise, return `false`.

An integer `y` is a power of three if there exists an integer `x` such that `y == 3^x`.


**Example 1:**

``` Java
Input: n = 12
Output: true
Explanation: 12 = 3^1 + 3^2
```


**Example 2:**

``` Java
Input: n = 91
Output: true
Explanation: 91 = 3^0 + 3^2 + 3^4
```


**Example 3:**

``` Java
Input: n = 21
Output: false
```

**Constraints:**

-   `1 <= n <= 10^7`
