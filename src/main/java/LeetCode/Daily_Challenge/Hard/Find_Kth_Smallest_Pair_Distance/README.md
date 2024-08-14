---
created: 2024-08-14T22:10:10 (UTC +03:00)
source: https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/?envType=daily-question&envId=2024-08-14
---
The **distance of a pair** of integers `a` and `b` is defined as the absolute difference between `a` and `b`.

Given an integer array `nums` and an integer `k`, return _the_ `k^th` _smallest **distance among all the pairs**_ `nums[i]` _and_ `nums[j]` _where_ `0 <= i < j < nums.length`.


**Example 1:**

``` Java
Input nums = [1,3,1], k = 1
Output 0
Explanation Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1<sup>st</sup> smallest distance pair is (1,1), and its distance is 0.
```


**Example 2:**

``` Java
Input nums = [1,1,1], k = 2
Output 0
```


**Example 3:**

``` Java
Input nums = [1,6,1], k = 3
Output 5
```


**Constraints:**

-   `n == nums.length`
-   `2 <= n <= 10^4`
-   `0 <= nums[i] <= 10^6`
-   `1 <= k <= n * (n - 1) / 2`
