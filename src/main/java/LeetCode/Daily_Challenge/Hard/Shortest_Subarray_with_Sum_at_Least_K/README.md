---
created: 2024-11-17T23:12:51 (UTC +03:00)
source: https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/?envType=daily-question&envId=2024-11-17
---
Given an integer array `nums` and an integer `k`, return _the length of the shortest non-empty **subarray** of_ `nums` _with a sum of at least_ `k`. If there is no such **subarray**, return `-1`.

A **subarray** is a **contiguous** part of an array.


**Example 1:**

``` Java
Input: nums = [1], k = 1
Output: 1
```


**Example 2:**

``` Java
Input: nums = [1,2], k = 4
Output: -1
```


**Example 3:**

``` Java
Input: nums = [2,-1,2], k = 3
Output: 3
```


**Constraints:**

-   `1 <= nums.length <= 10^5`
-   `-10<sup>5</sup> <= nums[i] <= 10^5`
-   `1 <= k <= 10^9`
