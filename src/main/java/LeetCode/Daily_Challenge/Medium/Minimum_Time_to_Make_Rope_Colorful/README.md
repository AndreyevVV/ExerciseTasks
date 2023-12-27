---
created: 2023-12-27T21:02:41 (UTC +01:00)
source: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/?envType=daily-question&envId=2023-12-27
---
Alice has `n` balloons arranged on a rope. You are given a **0-indexed** string `colors` where `colors[i]` is the color of the `i^th` balloon.

Alice wants the rope to be **colorful**. She does not want **two consecutive balloons** to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it **colorful**. You are given a **0-indexed** integer array `neededTime` where `neededTime[i]` is the time (in seconds) that Bob needs to remove the `i^th` balloon from the rope.

Return _the **minimum time** Bob needs to make the rope **colorful**_.

**Example 1:**

![img.png](img.png)

```
Input colors = "abaac", neededTime = [1,2,3,4,5]
Output 3
Explanation In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.
```

**Example 2:**

![img_1.png](img_1.png)

```
Input colors = "abc", neededTime = [1,2,3]
Output 0
Explanation The rope is already colorful. Bob does not need to remove any balloons from the rope.
```

**Example 3:**

![img_2.png](img_2.png)

```
Input colors = "aabaa", neededTime = [1,2,3,4,1]
Output 2
Explanation Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
```

**Constraints:**

-   `n == colors.length == neededTime.length`
-   `1 <= n <= 10^5`
-   `1 <= neededTime[i] <= 10^4`
-   `colors` contains only lowercase English letters.
