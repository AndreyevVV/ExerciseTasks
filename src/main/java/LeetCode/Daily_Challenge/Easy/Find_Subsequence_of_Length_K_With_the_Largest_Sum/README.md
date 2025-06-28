---
created: 2025-06-28T19:08:43 (UTC +03:00)
source: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/?envType=daily-question&envId=2025-06-28
---
You are given an integer array `nums` and an integer `k`. You want to find a **subsequence** of `nums` of length `k` that has the **largest** sum.

Return _**any** such subsequence as an integer array of length_ `k`.

A **subsequence** is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.


**Example 1:**

``` Java
Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
```


**Example 2:**

``` Java
Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
```


**Example 3:**

``` Java
Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
```


**Constraints:**

-   `1 <= nums.length <= 1000`
-   `-10^5 <= nums[i] <= 10^5`
-   `1 <= k <= nums.length`
