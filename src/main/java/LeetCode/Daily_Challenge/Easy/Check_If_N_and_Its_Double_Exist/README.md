---
created: 2024-12-01T21:45:05 (UTC +03:00)
source: https://leetcode.com/problems/check-if-n-and-its-double-exist/description/?envType=daily-question&envId=2024-12-01
---
Given an array `arr` of integers, check if there exist two indices `i` and `j` such that :

-   `i != j`
-   `0 <= i, j < arr.length`
-   `arr[i] == 2 * arr[j]`


**Example 1:**

``` Java
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
```


**Example 2:**

``` Java
Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
```


**Constraints:**

-   `2 <= arr.length <= 500`
-   `-10<sup>3</sup> <= arr[i] <= 10^3`
