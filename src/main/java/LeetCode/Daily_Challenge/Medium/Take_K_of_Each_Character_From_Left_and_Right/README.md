---
created: 2024-11-20T22:56:05 (UTC +03:00)
source: https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/?envType=daily-question&envId=2024-11-20
---
You are given a string `s` consisting of the characters `'a'`, `'b'`, and `'c'` and a non-negative integer `k`. Each minute, you may take either the **leftmost** character of `s`, or the **rightmost** character of `s`.

Return _the **minimum** number of minutes needed for you to take **at least**_ `k` _of each character, or return_ `-1` _if it is not possible to take_ `k` _of each character._


**Example 1:**

``` Java
Input: s = "aabaaaacaabc", k = 2
Output: 8
Explanation: 
Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
A total of 3 + 5 = 8 minutes is needed.
It can be proven that 8 is the minimum number of minutes needed.
```


**Example 2:**

``` Java
Input: s = "a", k = 1
Output: -1
Explanation: It is not possible to take one 'b' or 'c' so return -1.
```


**Constraints:**

-   `1 <= s.length <= 10^5`
-   `s` consists of only the letters `'a'`, `'b'`, and `'c'`.
-   `0 <= k <= s.length`
