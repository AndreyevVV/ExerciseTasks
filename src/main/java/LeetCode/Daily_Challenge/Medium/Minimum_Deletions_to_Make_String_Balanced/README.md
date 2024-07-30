---
created: 2024-07-30T21:42:05 (UTC +03:00)
source: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/?envType=daily-question&envId=2024-07-30
---
You are given a string `s` consisting only of characters `'a'` and `'b'`.

You can delete any number of characters in `s` to make `s` **balanced**. `s` is **balanced** if there is no pair of indices `(i,j)` such that `i < j` and `s[i] = 'b'` and `s[j]= 'a'`.

Return _the **minimum** number of deletions needed to make_ `s` _**balanced**_.


**Example 1:**

``` Java
Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aa<u>b</u>abb<u>a</u>b" -&gt; "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aab<u>a</u>bb<u>a</u>b" -&gt; "aabbbb").
```


**Example 2:**

``` Java
Input: s = "bbaaaaabb"
Output: 2
Explanation: The only solution is to delete the first two characters.
```


**Constraints:**

-   `1 <= s.length <= 10^5`
-   `s[i]` is `'a'` or `'b'`.
