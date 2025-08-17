---
created: 2025-08-17T17:04:23 (UTC +03:00)
source: https://leetcode.com/problems/new-21-game/description/?envType=daily-question&envId=2025-08-17
---
Alice plays the following game, loosely based on the card game **"21"**.

Alice starts with `0` points and draws numbers while she has less than `k` points. During each draw, she gains an integer number of points randomly from the range `[1, maxPts]`, where `maxPts` is an integer. Each draw is independent and the outcomes have equal probabilities.

Alice stops drawing numbers when she gets `k` **or more points**.

Return the probability that Alice has `n` or fewer points.

Answers within `10^(-5)` of the actual answer are considered accepted.


**Example 1:**

``` Java
Input: n = 10, k = 1, maxPts = 10
Output: 1.00000
Explanation: Alice gets a single card, then stops.
```


**Example 2:**

``` Java
Input: n = 6, k = 1, maxPts = 10
Output: 0.60000
Explanation: Alice gets a single card, then stops.
In 6 out of 10 possibilities, she is at or below 6 points.
```


**Example 3:**

``` Java
Input: n = 21, k = 17, maxPts = 10
Output: 0.73278
```


**Constraints:**

-   `0 <= k <= n <= 10^4`
-   `1 <= maxPts <= 10^4`
