---
created: 2025-01-02T17:18:53 (UTC +03:00)
source: https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02
---
You are given a **0-indexed** array of strings `words` and a 2D array of integers `queries`.

Each query `queries[i] = [l_i, r_i]` asks us to find the number of strings present in the range `l_i` to `r_i` (both **inclusive**) of `words` that start and end with a vowel.

Return _an array_ `ans` _of size_ `queries.length`_, where_ `ans[i]` _is the answer to the_ `i`^th _query_.

**Note** that the vowel letters are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.


**Example 1:**

``` Java
Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].
```


**Example 2:**

``` Java
Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].
```


**Constraints:**

-   `1 <= words.length <= 105`
-   `1 <= words[i].length <= 40`
-   `words[i]` consists only of lowercase English letters.
-   `sum(words[i].length) <= 3 * 10^5`
-   `1 <= queries.length <= 10^5`
-   `0 <= l_i <= r_i < words.length`
