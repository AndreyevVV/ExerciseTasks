---
created: 2024-12-10T23:15:09 (UTC +03:00)
source: https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/?envType=daily-question&envId=2024-12-10
---
You are given a string `s` that consists of lowercase English letters.

A string is called **special** if it is made up of only a single character. For example, the string `"abc"` is not special, whereas the strings `"ddd"`, `"zz"`, and `"f"` are special.

Return _the length of the **longest special substring** of_ `s` _which occurs **at least thrice**_, _or_ `-1` _if no special substring occurs at least thrice_.

A **substring** is a contiguous **non-empty** sequence of characters within a string.


**Example 1:**

``` Java
Input: s = "aaaa"
Output: 2
Explanation: The longest special substring which occurs thrice is "aa": substrings "<u><strong>aa</strong></u>aa", "a<u><strong>aa</strong></u>a", and "aa<u><strong>aa</strong></u>".
It can be shown that the maximum length achievable is 2.
```


**Example 2:**

``` Java
Input: s = "abcdef"
Output: -1
Explanation: There exists no special substring which occurs at least thrice. Hence return -1.
```


**Example 3:**

``` Java
Input: s = "abcaba"
Output: 1
Explanation: The longest special substring which occurs thrice is "a": substrings "<u><strong>a</strong></u>bcaba", "abc<u><strong>a</strong></u>ba", and "abcab<u><strong>a</strong></u>".
It can be shown that the maximum length achievable is 1.
```


**Constraints:**

-   `3 <= s.length <= 50`
-   `s` consists of only lowercase English letters.
