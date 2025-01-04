---
created: 2025-01-04T23:26:15 (UTC +03:00)
source: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2025-01-04
---
Given a string `s`, return _the number of **unique palindromes of length three** that are a **subsequence** of_ `s`.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted **once**.

A **palindrome** is a string that reads the same forwards and backwards.

A **subsequence** of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

-   For example, `"ace"` is a subsequence of `"_a_b_c_d_e_"`.


**Example 1:**

``` Java
Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "_a_a_b_c_a_")
- "aaa" (subsequence of "_aa_bc_a_")
- "aca" (subsequence of "_a_ab_ca_")
```


**Example 2:**

``` Java
Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
```


**Example 3:**

``` Java
Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "_bb_c_b_aba")
- "bcb" (subsequence of "_b_b_cb_aba")
- "bab" (subsequence of "_b_bcb_ab_a")
- "aba" (subsequence of "bbcb_aba_")
```


**Constraints:**

-   `3 <= s.length <= 10^5`
-   `s` consists of only lowercase English letters.
