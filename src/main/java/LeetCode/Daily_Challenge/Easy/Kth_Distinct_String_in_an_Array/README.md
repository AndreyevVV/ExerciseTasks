---
created: 2024-08-05T20:38:25 (UTC +03:00)
source: https://leetcode.com/problems/kth-distinct-string-in-an-array/description/?envType=daily-question&envId=2024-08-05
---
A **distinct string** is a string that is present only **once** in an array.

Given an array of strings `arr`, and an integer `k`, return _the_ `k^th` _**distinct string** present in_ `arr`. If there are **fewer** than `k` distinct strings, return _an **empty string**_ `""`.

Note that the strings are considered in the **order in which they appear** in the array.


**Example 1:**

``` Java
Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1^st, so it is the 1^st distinct string.
"a" appears 2^nd, so it is the 2^nd distinct string.
Since k == 2, "a" is returned. 
```


**Example 2:**

``` Java
Input: arr = ["aaa","aa","a"], k = 1
Output: "aaa"
Explanation:
All strings in arr are distinct, so the 1^st string "aaa" is returned.
```


**Example 3:**

``` Java
Input: arr = ["a","b","a"], k = 3
Output: ""
Explanation:
The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
```


**Constraints:**

-   `1 <= k <= arr.length <= 1000`
-   `1 <= arr[i].length <= 5`
-   `arr[i]` consists of lowercase English letters.
