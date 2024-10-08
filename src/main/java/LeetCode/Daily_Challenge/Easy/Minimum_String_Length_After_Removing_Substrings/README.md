---
created: 2024-10-07T23:09:19 (UTC +03:00)
source: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-10-07
---
You are given a string `s` consisting only of **uppercase** English letters.

You can apply some operations to this string where, in one operation, you can remove **any** occurrence of one of the substrings `"AB"` or `"CD"` from `s`.

Return _the **minimum** possible length of the resulting string that you can obtain_.

**Note** that the string concatenates after removing the substring and could produce new `"AB"` or `"CD"` substrings.


**Example 1:**

``` Java
Input: s = "ABFCACDB"
Output: 2
Explanation: We can do the following operations:
- Remove the substring "_AB_FCACDB", so s = "FCACDB".
- Remove the substring "FCA_CD_B", so s = "FCAB".
- Remove the substring "FC_AB_", so s = "FC".
So the resulting length of the string is 2.
It can be shown that it is the minimum length that we can obtain.
```


**Example 2:**

``` Java
Input: s = "ACBBD"
Output: 5
Explanation: We cannot do any operations on the string so the length remains the same.
```


**Constraints:**

-   `1 <= s.length <= 100`
-   `s` consists only of uppercase English letters.
