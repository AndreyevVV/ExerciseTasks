---
created: 2024-12-06T23:35:25 (UTC +03:00)
source: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/?envType=daily-question&envId=2024-12-06
---
You are given an integer array `banned` and two integers `n` and `maxSum`. You are choosing some number of integers following the below rules:

-   The chosen integers have to be in the range `[1, n]`.
-   Each integer can be chosen **at most once**.
-   The chosen integers should not be in the array `banned`.
-   The sum of the chosen integers should not exceed `maxSum`.

Return _the **maximum** number of integers you can choose following the mentioned rules_.


**Example 1:**

``` Java
Input: banned = [1,6,5], n = 5, maxSum = 6
Output: 2
Explanation: You can choose the integers 2 and 4.
2 and 4 are from the range [1, 5], both did not appear in banned, and their sum is 6, which did not exceed maxSum.
```


**Example 2:**

``` Java
Input: banned = [1,2,3,4,5,6,7], n = 8, maxSum = 1
Output: 0
Explanation: You cannot choose any integer while following the mentioned conditions.
```


**Example 3:**

``` Java
Input: banned = [11], n = 7, maxSum = 50
Output: 7
Explanation: You can choose the integers 1, 2, 3, 4, 5, 6, and 7.
They are from the range [1, 7], all did not appear in banned, and their sum is 28, which did not exceed maxSum.
```


**Constraints:**

-   `1 <= banned.length <= 10^4`
-   `1 <= banned[i], n <= 10^4`
-   `1 <= maxSum <= 10^9`
