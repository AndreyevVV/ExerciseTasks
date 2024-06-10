---
created: 2024-06-10T21:03:20 (UTC +03:00)
source: https://leetcode.com/problems/height-checker/description/?envType=daily-question&envId=2024-06-10
---
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in **non-decreasing order** by height. Let this ordering be represented by the integer array `expected` where `expected[i]` is the expected height of the `i^>th>` student in line.

You are given an integer array `heights` representing the **current order** that the students are standing in. Each `heights[i]` is the height of the `i^>th>` student in line (**0-indexed**).

Return _the **number of indices** where_ `heights[i] != expected[i]`.

**Example 1:**

``` Java
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,_4_,2,_1_,_3_]
expected: [1,1,_1_,2,_3_,_4_]
Indices 2, 4, and 5 do not match.
```

**Example 2:**

``` Java
Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [_5_,_1_,_2_,_3_,_4_]
expected: [_1_,_2_,_3_,_4_,_5_]
All indices do not match.
```

**Example 3:**

``` Java
Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
```

**Constraints:**

-   `1 <= heights.length <= 100`
-   `1 <= heights[i] <= 100`
