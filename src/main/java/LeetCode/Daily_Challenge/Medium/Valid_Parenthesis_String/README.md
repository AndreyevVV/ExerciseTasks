---
created: 2024-04-07T19:25:55 (UTC +03:00)
source: https://leetcode.com/problems/valid-parenthesis-string/description/?envType=daily-question&envId=2024-04-07
---
Given a string `s` containing only three types of characters: `'('`, `')'` and `'*'`, return `true` _if_ `s` _is **valid**_.

The following rules define a **valid** string:

-   Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
-   Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
-   Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
-   `'*'` could be treated as a single right parenthesis `')'` or a single left parenthesis `'('` or an empty string `""`.


**Example 1:**

``` Java
Input: s = "()"
Output: true
```


**Example 2:**

``` Java
Input: s = "(*)"
Output: true
```


**Example 3:**

``` Java
Input: s = "(*))"
Output: true
```


**Constraints:**

-   `1 <= s.length <= 100`
-   `s[i]` is `'('`, `')'` or `'*'`.
