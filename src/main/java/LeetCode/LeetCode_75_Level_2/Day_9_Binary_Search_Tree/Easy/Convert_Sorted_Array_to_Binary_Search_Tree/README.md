---
created: 2023-05-23T23:17:14 (UTC +02:00)
source: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan&id=level-2
---
Given an integer array `nums` where the elements are sorted in **ascending order**, convert _it to a_

**_height-balanced_**

_binary search tree_.

**Example 1:**

![img.png](img.png)

```
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:
```

![img_2.png](img_2.png)

**Example 2:**

![img_3.png](img_3.png)

```
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

```

**Constraints:**

-   `1 <= nums.length <= 10^4`
-   `-10^4 <= nums[i] <= 10^4`
-   `nums` is sorted in a **strictly increasing** order.
