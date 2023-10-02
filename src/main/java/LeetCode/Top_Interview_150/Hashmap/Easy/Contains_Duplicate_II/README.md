---
created: 2023-10-02T21:36:04 (UTC +02:00)
source: https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
---
Given an integer array `nums` and an integer `k`, return `true` _if there are two **distinct indices**_ `i` _and_ `j` _in the array such that_ `nums[i] == nums[j]` _and_ `abs(i - j) <= k`.

**Example 1:**

```
Input: nums = [1,2,3,1], k = 3
Output: true

```

**Example 2:**

```
Input: nums = [1,0,1,1], k = 1
Output: true

```

**Example 3:**

```
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

```

**Constraints:**

-   `1 <= nums.length <= 10^5`
-   `-10^9 <= nums[i] <= 10^9`
-   `0 <= k <= 10^5`
