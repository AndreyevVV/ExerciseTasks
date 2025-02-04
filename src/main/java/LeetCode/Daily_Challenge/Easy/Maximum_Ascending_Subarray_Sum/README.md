---
created: 2025-02-04T19:15:26 (UTC +03:00)
source: https://leetcode.com/problems/maximum-ascending-subarray-sum/description/?envType=daily-question&envId=2025-02-04
---
Given an array of positive integers `nums`, return the _maximum possible sum of an **ascending** subarray in_ `nums`.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray `[nums_l, nums_l+1, ..., nums_r-1, nums_r]` is **ascending** if for all `i` where `l <= i < r`, `nums_i  < nums_i+1`. Note that a subarray of size `1` is **ascending**.


**Example 1:**

``` Java
Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
```


**Example 2:**

``` Java
Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
```


**Example 3:**

``` Java
Input: nums = [12,17,15,13,10,11,12]
Output: 33
Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
```

**Constraints:**

-   `1 <= nums.length <= 100`
-   `1 <= nums[i] <= 100`
