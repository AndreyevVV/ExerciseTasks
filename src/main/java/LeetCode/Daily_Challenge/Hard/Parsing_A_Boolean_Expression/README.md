---
created: 2024-10-20T23:17:53 (UTC +03:00)
source: https://leetcode.com/problems/parsing-a-boolean-expression/description/?envType=daily-question&envId=2024-10-20
---
A **boolean expression** is an expression that evaluates to either `true` or `false`. It can be in one of the following shapes:

-   `'t'` that evaluates to `true`.
-   `'f'` that evaluates to `false`.
-   `'!(subExpr)'` that evaluates to **the logical NOT** of the inner expression `subExpr`.
-   `'&(subExpr_1, subExpr_2, ..., subExpr_n)'` that evaluates to **the logical AND** of the inner expressions `subExpr_1, subExpr_2, ..., subExpr_n` where `n >= 1`.
-   `'|(subExpr_1, subExpr_2, ..., subExpr_n)'` that evaluates to **the logical OR** of the inner expressions `subExpr_1, subExpr_2, ..., subExpr_n` where `n >= 1`.

Given a string `expression` that represents a **boolean expression**, return _the evaluation of that expression_.

It is **guaranteed** that the given expression is valid and follows the given rules.


**Example 1:**

``` Java
Input: expression = "&(|(f))"
Output: false
Explanation: 
First, evaluate |(f) --> f. The expression is now "&(f)".
Then, evaluate &(f) --> f. The expression is now "f".
Finally, return false.
```


**Example 2:**

``` Java
Input: expression = "|(f,f,f,t)"
Output: true
Explanation: The evaluation of (false OR false OR false OR true) is true.
```


**Example 3:**

``` Java
Input: expression = "!(&(f,t))"
Output: true
Explanation: 
First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
Then, evaluate !(f) --> NOT false --> true. We return true.
```


**Constraints:**

-   `1 <= expression.length <= 2 * 10^4`
-   expression\[i\] is one following characters: `'('`, `')'`, `'&'`, `'|'`, `'!'`, `'t'`, `'f'`, and `','`.
