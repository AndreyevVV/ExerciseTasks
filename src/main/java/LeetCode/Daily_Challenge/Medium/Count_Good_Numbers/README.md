---
created: 2025-04-13T22:17:43 (UTC +03:00)
source: https://leetcode.com/problems/count-good-numbers/description/?envType=daily-question&envId=2025-04-13
---
A digit string is **good** if the digits **(0-indexed)** at **even** indices are **even** and the digits at **odd** indices are **prime** (`2`, `3`, `5`, or `7`).

-   For example, `"2582"` is good because the digits (`2` and `8`) at even positions are even and the digits (`5` and `2`) at odd positions are prime. However, `"3245"` is **not** good because `3` is at an even index but is not even.

Given an integer `n`, return _the **total** number of good digit strings of length_ `n`. Since the answer may be large, **return it modulo** `10^9 + 7`.

A **digit string** is a string consisting of digits `0` through `9` that may contain leading zeros.


**Example 1:**

``` Java
Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
```


**Example 2:**

``` Java
Input: n = 4
Output: 400
```


**Example 3:**

``` Java
Input: n = 50
Output: 564908303
```

**Constraints:**

-   `1 <= n <= 10^15`
