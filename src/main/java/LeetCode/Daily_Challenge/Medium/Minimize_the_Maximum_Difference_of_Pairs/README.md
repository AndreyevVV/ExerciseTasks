---
created: 2025-06-13T06:29:08 (UTC +03:00)
source: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description/?envType=daily-question&envId=2025-06-13
---
You are given a **0-indexed** integer array `nums` and an integer `p`. Find `p` pairs of indices of `nums` such that the **maximum** difference amongst all the pairs is **minimized**. Also, ensure no index appears more than once amongst the `p` pairs.

Note that for a pair of elements at the index `i` and `j`, the difference of this pair is `|nums[i] - nums[j]|`, where `|x|` represents the **absolute** **value** of `x`.

Return _the **minimum** **maximum** difference among all_ `p` _pairs._ We define the maximum of an empty set to be zero.


**Example 1:**

``` Java
Input: nums = [10,1,2,7,1,3], p = 2
Output: 1
Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5. 
The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.
```


**Example 2:**

``` Java
Input: nums = [4,2,1,2], p = 1
Output: 0
Explanation: Let the indices 1 and 3 form a pair. The difference of that pair is |2 - 2| = 0, which is the minimum we can attain.
```


**Constraints:**

-   `1 <= nums.length <= 10^5`
-   `0 <= nums[i] <= 10^9`
-   `0 <= p <= (nums.length)/2`
