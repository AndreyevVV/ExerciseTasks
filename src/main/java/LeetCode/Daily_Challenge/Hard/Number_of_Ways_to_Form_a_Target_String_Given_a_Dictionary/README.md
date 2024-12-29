---
created: 2024-12-29T19:14:27 (UTC +03:00)
source: https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/?envType=daily-question&envId=2024-12-29
---
You are given a list of strings of the **same length** `words` and a string `target`.

Your task is to form `target` using the given `words` under the following rules:

-   `target` should be formed from left to right.
-   To form the `i^th` character (**0-indexed**) of `target`, you can choose the `k^th` character of the `j^th` string in `words` if `target[i] = words[j][k]`.
-   Once you use the `k^th` character of the `j^th` string of `words`, you **can no longer** use the `x^th` character of any string in `words` where `x <= k`. In other words, all characters to the left of or at index `k` become unusuable for every string.
-   Repeat the process until you form the string `target`.

**Notice** that you can use **multiple characters** from the **same string** in `words` provided the conditions above are met.

Return _the number of ways to form `target` from `words`_. Since the answer may be too large, return it **modulo** `10^9 + 7`.


**Example 1:**

``` Java
Input: words = ["acca","bbbb","caca"], target = "aba"
Output: 6
Explanation: There are 6 ways to form target.
"aba" -> index 0 ("_a_cca"), index 1 ("b_b_bb"), index 3 ("cac_a_")
"aba" -> index 0 ("_a_cca"), index 2 ("bb_b_b"), index 3 ("cac_a_")
"aba" -> index 0 ("_a_cca"), index 1 ("b_b_bb"), index 3 ("acc_a_")
"aba" -> index 0 ("_a_cca"), index 2 ("bb_b_b"), index 3 ("acc_a_")
"aba" -> index 1 ("c_a_ca"), index 2 ("bb_b_b"), index 3 ("acc_a_")
"aba" -> index 1 ("c_a_ca"), index 2 ("bb_b_b"), index 3 ("cac_a_")
```


**Example 2:**

``` Java
Input: words = ["abba","baab"], target = "bab"
Output: 4
Explanation: There are 4 ways to form target.
"bab" -> index 0 ("_b_aab"), index 1 ("b_a_ab"), index 2 ("ab_b_a")
"bab" -> index 0 ("_b_aab"), index 1 ("b_a_ab"), index 3 ("baa_b_")
"bab" -> index 0 ("_b_aab"), index 2 ("ba_a_b"), index 3 ("baa_b_")
"bab" -> index 1 ("a_b_ba"), index 2 ("ba_a_b"), index 3 ("baa_b_")
```


**Constraints:**

-   `1 <= words.length <= 1000`
-   `1 <= words[i].length <= 1000`
-   All strings in `words` have the same length.
-   `1 <= target.length <= 1000`
-   `words[i]` and `target` contain only lowercase English letters.
