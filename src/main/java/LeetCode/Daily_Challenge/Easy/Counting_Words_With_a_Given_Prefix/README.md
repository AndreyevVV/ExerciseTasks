---
created: 2025-01-09T23:24:57 (UTC +03:00)
source: https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09
---
You are given an array of strings `words` and a string `pref`.

Return _the number of strings in_ `words` _that contain_ `pref` _as a **prefix**_.

A **prefix** of a string `s` is any leading contiguous substring of `s`.


**Example 1:**

``` Java
Input: words = ["pay","_at_tention","practice","_at_tend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "_at_tention" and "_at_tend".
```


**Example 2:**

``` Java
Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.
```


**Constraints:**

-   `1 <= words.length <= 100`
-   `1 <= words[i].length, pref.length <= 100`
-   `words[i]` and `pref` consist of lowercase English letters.
