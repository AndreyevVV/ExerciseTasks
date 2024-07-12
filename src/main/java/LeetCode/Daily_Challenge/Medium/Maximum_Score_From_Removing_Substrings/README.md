---
created: 2024-07-12T22:06:50 (UTC +03:00)
source: https://leetcode.com/problems/maximum-score-from-removing-substrings/description/?envType=daily-question&envId=2024-07-12
---
You are given a string `s` and two integers `x` and `y`. You can perform two types of operations any number of times.

-   Remove substring `"ab"` and gain `x` points.
    -   For example, when removing `"ab"` from `"c_ab_xbae"` it becomes `"cxbae"`.
-   Remove substring `"ba"` and gain `y` points.
    -   For example, when removing `"ba"` from `"cabx_ba_e"` it becomes `"cabxe"`.

Return _the maximum points you can gain after applying the above operations on_ `s`.


**Example 1:**

``` Java
Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaa_ba_b". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaa_ab_". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcb_ba_a". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbc_ba_". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
```


**Example 2:**

``` Java
Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
```


**Constraints:**

-   `1 <= s.length <= 10^5`
-   `1 <= x, y <= 10^4`
-   `s` consists of lowercase English letters.
