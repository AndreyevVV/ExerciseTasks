---
created: 2024-04-01T21:33:54 (UTC +03:00)
source: https://leetcode.com/problems/excel-sheet-column-title/description/
---
Given an integer `columnNumber`, return _its corresponding column title as it appears in an Excel sheet_.

**For example:**

``` Java
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
```

**Example 1:**

``` Java 
Input: columnNumber = 1
Output: "A"
```


**Example 2:**

``` Java
Input: columnNumber = 28
Output: "AB"
```


**Example 3:**

``` Java
Input: columnNumber = 701
Output: "ZY"
```


**Constraints:**

* `1 <= columnNumber <= 2^31 - 1`
