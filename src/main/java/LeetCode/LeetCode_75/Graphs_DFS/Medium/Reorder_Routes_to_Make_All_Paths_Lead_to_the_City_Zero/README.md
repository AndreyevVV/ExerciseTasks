---
created: 2023-08-05T17:42:45 (UTC +02:00)
source: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/?envType=study-plan-v2&envId=leetcode-75 
---
There are `n` cities numbered from `0` to `n - 1` and `n - 1` roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by `connections` where `connections[i] = [a_i, b_i]` represents a road from city `a_i` to city `b_i`.

This year, there will be a big event in the capital (city `0`), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city `0`. Return the **minimum** number of edges changed.

It's **guaranteed** that each city can reach city `0` after reorder.

**Example 1:**

![img.png](img.png)

```
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

```

**Example 2:**

![img_1.png](img_1.png)

```
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

```

**Example 3:**

```
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0

```

**Constraints:**

-   `2 <= n <= 5 * 10^4`
-   `connections.length == n - 1`
-   `connections[i].length == 2`
-   `0 <= a_i, b_i <= n - 1`
-   `a_i != b_i`
