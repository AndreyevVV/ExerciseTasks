---
created: 2025-06-27T17:39:23 (UTC +03:00)
source: https://leetcode.com/problems/longest-subsequence-repeated-k-times/description/?envType=daily-question&envId=2025-06-27
---
You are given a string `s` of length `n`, and an integer `k`. You are tasked to find the **longest subsequence repeated** `k` times in string `s`.

A **subsequence** is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

A subsequence `seq` is **repeated** `k` times in the string `s` if `seq * k` is a subsequence of `s`, where `seq * k` represents a string constructed by concatenating `seq` `k` times.

-   For example, `"bba"` is repeated `2` times in the string `"bababcba"`, because the string `"bbabba"`, constructed by concatenating `"bba"` `2` times, is a subsequence of the string `"**_b_**a**_bab_**c**_ba_**"`.

Return _the **longest subsequence repeated**_ `k` _times in string_ `s`_. If multiple such subsequences are found, return the **lexicographically largest** one. If there is no such subsequence, return an **empty** string_.


**Example 1:**

![img.png](img.png)

``` Java
Input: s = "letsleetcode", k = 2
Output: "let"
Explanation: There are two longest subsequences repeated 2 times: "let" and "ete".
"let" is the lexicographically largest one.
```


**Example 2:**

``` Java
Input: s = "bb", k = 2
Output: "b"
Explanation: The longest subsequence repeated 2 times is "b".
```


**Example 3:**

``` Java
Input: s = "ab", k = 2
Output: ""
Explanation: There is no subsequence repeated 2 times. Empty string is returned.
```


**Constraints:**

-   `n == s.length`
-   `2 <= n, k <= 2000`
-   `2 <= n < k * 8`
-   `s` consists of lowercase English letters.
