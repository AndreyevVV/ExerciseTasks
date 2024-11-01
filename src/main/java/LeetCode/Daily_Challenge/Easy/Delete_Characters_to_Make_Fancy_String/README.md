---
created: 2024-11-01T07:10:23 (UTC +03:00)
source: https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/?envType=daily-question&envId=2024-11-01
---
A **fancy string** is a string where no **three** **consecutive** characters are equal.

Given a string `s`, delete the **minimum** possible number of characters from `s` to make it **fancy**.

Return _the final string after the deletion_. It can be shown that the answer will always be **unique**.


**Example 1:**

``` Java
Input: s = "le_e_etcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
```


**Example 2:**

``` Java
Input: s = "_a_aab_aa_aa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
```


**Example 3:**

``` Java
Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
```


**Constraints:**

-   `1 <= s.length <= 10^5`
-   `s` consists only of lowercase English letters.
