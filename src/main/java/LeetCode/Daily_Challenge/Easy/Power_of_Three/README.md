---
created: 2025-08-13T15:56:07 (UTC +03:00)
source: https://leetcode.com/problems/power-of-three/description/?envType=daily-question&envId=2025-08-13
---
Given an integer `n`, return _`true` if it is a power of three. Otherwise, return `false`_.

An integer `n` is a power of three, if there exists an integer `x` such that `n == 3^x`.

**Example 1:**

``` Java
Input: n = 27
Output: true
Explanation: 27 = 3^3
```

**Example 2:**

``` Java
Input: n = 0
Output: false
Explanation: There is no x where 3^x = 0.
```

**Example 3:**

``` Java
Input: n = -1
Output: false
Explanation: There is no x where 3^x = (-1).
```

**Constraints:**

-   `-2^31 <= n <= 2^31 - 1`

**Follow up:** Could you solve it without loops/recursion?
