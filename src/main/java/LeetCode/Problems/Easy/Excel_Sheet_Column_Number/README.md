---
created: 2024-04-02T08:33:04 (UTC +03:00)
source: https://leetcode.com/problems/excel-sheet-column-number/description/
---
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.


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
Input: columnTitle = "A"
Output: 1
```


**Example 2:**

``` Java
Input: columnTitle = "AB"
Output: 28
```


**Example 3:**

``` Java
Input: columnTitle = "ZY"
Output: 701
```


**Constraints:**

* `1 <= columnTitle.length <= 7`
* `columnTitle` consists only of uppercase English letters.
* `columnTitle` is in the range ["A", "FXSHRXW"].
