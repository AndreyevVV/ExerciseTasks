---
created: 2024-04-30T23:03:34 (UTC +03:00)
source: https://leetcode.com/problems/number-of-wonderful-substrings/description/?envType=daily-question&envId=2024-04-30
---
A **wonderful** string is a string where **at most one** letter appears an **odd** number of times.

-   For example, `"ccjjc"` and `"abab"` are wonderful, but `"ab"` is not.

Given a string `word` that consists of the first ten lowercase English letters (`'a'` through `'j'`), return _the **number of wonderful non-empty substrings** in_ `word`_. If the same substring appears multiple times in_ `word`_, then count **each occurrence** separately._

A **substring** is a contiguous sequence of characters in a string.


**Example 1:**

``` Java
Input: word = "aba"
Output: 4
Explanation: The four wonderful substrings are underlined below:
- "_a_ba" -&gt; "a"
- "a_b_a" -&gt; "b"
- "ab_a_" -&gt; "a"
- "_aba_" -&gt; "aba"
```


**Example 2:**

``` Java
Input: word = "aabb"
Output: 9
Explanation: The nine wonderful substrings are underlined below:
- "_a_abb" -&gt; "a"
- "_aa_bb" -&gt; "aa"
- "_aab_b" -&gt; "aab"
- "_aabb_" -&gt; "aabb"
- "a_a_bb" -&gt; "a"
- "a_abb_" -&gt; "abb"
- "aa_b_b" -&gt; "b"
- "aa_bb_" -&gt; "bb"
- "aab_b_" -&gt; "b"
```

**Example 3:**

``` Java
Input: word = "he"
Output: 2
Explanation: The two wonderful substrings are underlined below:
- "_h_e" -&gt; "h"
- "h_e_" -&gt; "e"
```

**Constraints:**

-   `1 <= word.length <= 10^5`
-   `word` consists of lowercase English letters from `'a'` to `'j'`.
