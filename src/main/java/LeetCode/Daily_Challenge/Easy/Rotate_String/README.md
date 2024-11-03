---
created: 2024-11-03T23:14:04 (UTC +03:00)
source: https://leetcode.com/problems/rotate-string/description/?envType=daily-question&envId=2024-11-03
---
Given two strings `s` and `goal`, return `true` _if and only if_ `s` _can become_ `goal` _after some number of **shifts** on_ `s`.

A **shift** on `s` consists of moving the leftmost character of `s` to the rightmost position.

-   For example, if `s = "abcde"`, then it will be `"bcdea"` after one shift.


**Example 1:**

``` Java
Input: s = "abcde", goal = "cdeab"
Output: true
```


**Example 2:**

``` Java
Input: s = "abcde", goal = "abced"
Output: false
```

**Constraints:**

-   `1 <= s.length, goal.length <= 100`
-   `s` and `goal` consist of lowercase English letters.
