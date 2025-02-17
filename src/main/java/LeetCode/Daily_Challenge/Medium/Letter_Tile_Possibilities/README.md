---
created: 2025-02-17T16:24:52 (UTC +03:00)
source: https://leetcode.com/problems/letter-tile-possibilities/description/?envType=daily-question&envId=2025-02-17
---
You have `n` `tiles`, where each tile has one letter `tiles[i]` printed on it.

Return _the number of possible non-empty sequences of letters_ you can make using the letters printed on those `tiles`.


**Example 1:**

``` Java
Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
```


**Example 2:**

``` Java
Input: tiles = "AAABBC"
Output: 188
```


**Example 3:**

``` Java
Input: tiles = "V"
Output: 1
```


**Constraints:**

-   `1 <= tiles.length <= 7`
-   `tiles` consists of uppercase English letters.
