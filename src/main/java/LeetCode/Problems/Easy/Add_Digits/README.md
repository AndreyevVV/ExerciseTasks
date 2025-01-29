---
created: 2025-01-29T23:39:59 (UTC +03:00)
source: https://leetcode.com/problems/add-digits/description/
---
Given an integer `num`, repeatedly add all its digits until the result has only one digit, and return it.


**Example 1:**

``` Java
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
```


**Example 2:**

``` Java
Input: num = 0
Output: 0
```


**Constraints:**

-   `0 <= num <= 2^31 - 1`

**Follow up:** Could you do it without any loop/recursion in `O(1)` runtime?
