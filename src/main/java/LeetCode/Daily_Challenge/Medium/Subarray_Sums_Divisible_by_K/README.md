---
created: 2024-06-09T14:00:51 (UTC +03:00)
source: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/?envType=daily-question&envId=2024-06-09
---
Given an integer array `nums` and an integer `k`, return _the number of non-empty **subarrays** that have a sum divisible by `k`_.

A **subarray** is a **contiguous** part of an array.


**Example 1:**

``` Java
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
```


**Example 2:**

``` Java
Input: nums = [5], k = 9
Output: 0
```

**Constraints:**

* `1 <= nums.length <= 3 * 10^4`
* `-10^4 <= nums[i] <= 10^4`
* `2 <= k <= 10^4`