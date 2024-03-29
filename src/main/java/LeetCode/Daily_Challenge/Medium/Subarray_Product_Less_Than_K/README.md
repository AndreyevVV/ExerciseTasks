---
created: 2024-03-27T22:15:17 (UTC +03:00)
source: https://leetcode.com/problems/subarray-product-less-than-k/description/?envType=daily-question&envId=2024-03-27
---
Given an array of integers `nums` and an integer `k`, return _the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than `k`_.


**Example 1:**

``` Java
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
```


**Example 2:**

``` Java
Input: nums = [1,2,3], k = 0
Output: 0
```


**Constraints:**

* `1 <= nums.length <= 3 * 104`
* `1 <= nums[i] <= 1000`
* `0 <= k <= 106`
