---
created: 2025-05-24T09:53:49 (UTC +03:00)
source: https://leetcode.com/problems/find-words-containing-character/description/?envType=daily-question&envId=2025-05-24
---
You are given a **0-indexed** array of strings `words` and a character `x`.

Return _an **array of indices** representing the words that contain the character_ `x`.

**Note** that the returned array may be in **any** order.


**Example 1:**

``` Java
Input: words = ["leet","code"], x = "e"
Output: [0,1]
Explanation: "e" occurs in both words: "l_eet", and "cod_e". Hence, we return indices 0 and 1.
```


**Example 2:**

``` Java
Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
Output: [0,2]
Explanation: "a" occurs in "_abc_", and "_aaaa_". Hence, we return indices 0 and 2.
```


**Example 3:**

``` Java
Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
Output: []
Explanation: "z" does not occur in any of the words. Hence, we return an empty array.
```

**Constraints:**

-   `1 <= words.length <= 50`
-   `1 <= words[i].length <= 50`
-   `x` is a lowercase English letter.
-   `words[i]` consists only of lowercase English letters.
