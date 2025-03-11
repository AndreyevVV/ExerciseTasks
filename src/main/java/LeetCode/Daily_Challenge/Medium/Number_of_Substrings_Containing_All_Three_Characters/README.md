---
created: 2025-03-11T11:30:32 (UTC +03:00)
source: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2025-03-11
---
Given a string `s` consisting only of characters _a_, _b_ and _c_.

Return the number of substrings containing **at least** one occurrence of all these characters _a_, _b_ and _c_.


**Example 1:**

``` Java
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a,band c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
```


**Example 2:**

``` Java
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
```


**Example 3:**

``` Java
Input: s = "abc"
Output: 1
```


**Constraints:**

-   `3 <= s.length <= 5 x 10^4`
-   `s` only consists of _a_, _b_ or _c_ characters.
