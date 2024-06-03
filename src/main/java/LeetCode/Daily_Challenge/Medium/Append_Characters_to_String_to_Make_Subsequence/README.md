---
created: 2024-06-03T23:04:30 (UTC +03:00)
source: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/?envType=daily-question&envId=2024-06-03
---
You are given two strings `s` and `t` consisting of only lowercase English letters.

Return _the minimum number of characters that need to be appended to the end of_ `s` _so that_ `t` _becomes a **subsequence** of_ `s`.

A **subsequence** is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.


**Example 1:**

``` Java
Input: s = "coaching", t = "coding"
Output: 4
Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
Now, t is a subsequence of s ("_co_aching_ding_").
It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
```


**Example 2:**

``` Java
Input: s = "abcde", t = "a"
Output: 0
Explanation: t is already a subsequence of s ("_a_bcde").
```


**Example 3:**

``` Java
Input: s = "z", t = "abcde"
Output: 5
Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
Now, t is a subsequence of s ("z_abcde_").
It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
```

**Constraints:**

-   `1 <= s.length, t.length <= 10^5`
-   `s` and `t` consist only of lowercase English letters.
