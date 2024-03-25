---
created: 2024-03-25T22:46:24 (UTC +03:00)
source: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/?envType=daily-question&envId=2024-03-25
---
Given an integer array `nums` of length `n` where all the integers of `nums` are in the range `[1, n]` and each integer appears **once** or **twice**, return _an array of all the integers that appears **twice**_.

You must write an algorithm that runs in `O(n)` time and uses only constant extra space.


**Example 1:**

``` Java
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
```


**Example 2:**

``` Java
Input: nums = [1,1,2]
Output: [1]]
```


**Example 3:**

``` Java
Input: nums = [1]
Output: []
```


**Constraints:**

* `n == nums.length`
* `1 <= n <= 105`
* `1 <= nums[i] <= n`
* `Each element in nums appears once or twice`.
