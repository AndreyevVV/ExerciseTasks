---
created: 2025-02-12T21:10:53 (UTC +03:00)
source: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/?envType=daily-question&envId=2025-02-12
---
You are given a **0-indexed** array `nums` consisting of **positive** integers. You can choose two indices `i` and `j`, such that `i != j`, and the sum of digits of the number `nums[i]` is equal to that of `nums[j]`.

Return _the **maximum** value of_ `nums[i] + nums[j]` _that you can obtain over all possible indices_ `i` _and_ `j` _that satisfy the conditions._


**Example 1:**

``` Java
Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
```


**Example 2:**

``` Java
Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
```


**Constraints:**

-   `1 <= nums.length <= 10^5`
-   `1 <= nums[i] <= 10^9`
