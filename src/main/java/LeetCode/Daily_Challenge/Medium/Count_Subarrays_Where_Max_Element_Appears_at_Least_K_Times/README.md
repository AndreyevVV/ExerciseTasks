---
created: 2024-03-29T21:29:45 (UTC +03:00)
source: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29
---
You are given an integer array `nums` and a **positive** integer `k`.

Return _the number of subarrays where the **maximum** element of_ `nums` _appears **at least**_ `k` _times in that subarray._

A **subarray** is a contiguous sequence of elements within an array.

**Example 1:**

``` Java
Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
```

**Example 2:**

``` Java
Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.
```

**Constraints:**

-   `1 <= nums.length <= 10^5`
-   `1 <= nums[i] <= 10^6`
-   `1 <= k <= 10^5`
