---
created: 2024-07-06T23:15:59 (UTC +03:00)
source: https://leetcode.com/problems/pass-the-pillow/description/?envType=daily-question&envId=2024-07-06
---
There are `n` people standing in a line labeled from `1` to `n`. The first person in the line is holding a pillow initially. Every second, the person holding the pillow passes it to the next person standing in the line. Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.

-   For example, once the pillow reaches the `n^th` person they pass it to the `n - 1^th` person, then to the `n - 2^th` person and so on.

Given the two positive integers `n` and `time`, return _the index of the person holding the pillow after_ `time` _seconds_.


**Example 1:**

``` Java
Input: n = 4, time = 5
Output: 2
Explanation: People pass the pillow in the following way: 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 3 -&gt; 2.
After five seconds, the 2^nd person is holding the pillow.
```


**Example 2:**

``` Java
Input: n = 3, time = 2
Output: 3
Explanation: People pass the pillow in the following way: 1 -&gt; 2 -&gt; 3.
After two seconds, the 3^r^d person is holding the pillow.
```


**Constraints:**

-   `2 <= n <= 1000`
-   `1 <= time <= 1000`
