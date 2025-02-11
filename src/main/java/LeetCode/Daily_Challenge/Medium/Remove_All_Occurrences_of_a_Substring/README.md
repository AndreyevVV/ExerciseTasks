---
created: 2025-02-11T18:58:20 (UTC +03:00)
source: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/?envType=daily-question&envId=2025-02-11
---
Given two strings `s` and `part`, perform the following operation on `s` until **all** occurrences of the substring `part` are removed:

-   Find the **leftmost** occurrence of the substring `part` and **remove** it from `s`.

Return `s` _after removing all occurrences of_ `part`.

A **substring** is a contiguous sequence of characters in a string.


**Example 1:**

``` Java
Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "da_abc_baabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "daba_abc_bc", remove "abc" starting at index 4, so s = "dababc".
- s = "dab_abc_", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
```


**Example 2:**

``` Java
Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxx_xy_yyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axx_xy_yyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "ax_xy_yb", remove "xy" starting at index 2 so s = "axyb".
- s = "a_xy_b", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".
```


**Constraints:**

-   `1 <= s.length <= 1000`
-   `1 <= part.length <= 1000`
-   `s` and `part` consists of lowercase English letters.
