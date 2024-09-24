---
created: 2024-09-19T23:41:57 (UTC +03:00)
source: https://leetcode.com/problems/different-ways-to-add-parentheses/description/?envType=daily-question&envId=2024-09-19
---
Given a string `expression` of numbers and operators, return _all possible results from computing all the different possible ways to group numbers and operators_. You may return the answer in **any order**.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed `10^4`.


**Example 1:**

``` Java
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2
```


**Example 2:**

``` Java
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
```


**Constraints:**

-   `1 <= expression.length <= 20`
-   `expression` consists of digits and the operator `'+'`, `'-'`, and `'*'`.
-   All the integer values in the input expression are in the range `[0, 99]`.
-   The integer values in the input expression do not have a leading `'-'` or `'+'` denoting the sign.