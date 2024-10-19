---
created: 2024-10-19T23:30:06 (UTC +03:00)
source: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/?envType=daily-question&envId=2024-10-19
---
Given two positive integers `n` and `k`, the binary string `S_n` is formed as follows:

-   `S_1 = "0"`
-   `S_i = S_i - 1 + "1" + reverse(invert(S_(i - 1)))` for `i > 1`

Where `+` denotes the concatenation operation, `reverse(x)` returns the reversed string `x`, and `invert(x)` inverts all the bits in `x` (`0` changes to `1` and `1` changes to `0`).

For example, the first four strings in the above sequence are:

-   `S_1  = "0"`
-   `S_2  = "0**1**1"`
-   `S_3  = "011**1**001"`
-   `S_4 = "0111001**1**0110001"`

Return _the_ `k^th` _bit_ _in_ `S_n`. It is guaranteed that `k` is valid for the given `n`.


**Example 1:**

``` Java
Input: n = 3, k = 1
Output: "0"
Explanation: S_3 is "_0_111001".
The 1^st bit is "0".
```


**Example 2:**

``` Java
Input: n = 4, k = 11
Output: "1"
Explanation: S_4 is "0111001101_1_0001".
The 11^th bit is "1".
```


**Constraints:**

-   `1 <= n <= 20`
-   `1 <= k <= 2^n - 1`
