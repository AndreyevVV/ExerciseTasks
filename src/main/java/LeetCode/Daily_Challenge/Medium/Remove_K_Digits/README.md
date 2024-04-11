---
created: 2024-04-11T19:58:14 (UTC +03:00)
source: https://leetcode.com/problems/remove-k-digits/description/?envType=daily-question&envId=2024-04-11
---
Given string num representing a non-negative integer `num`, and an integer `k`, return _the smallest possible integer after removing_ `k` _digits from_ `num`.

**Example 1:**

``` Java
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
```


**Example 2:**

``` Java
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
```


**Example 3:**

``` Java
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
```


**Constraints:**

-   `1 <= k <= num.length <= 10^5`
-   `num` consists of only digits.
-   `num` does not have any leading zeros except for the zero itself.
