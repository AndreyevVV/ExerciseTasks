---
created: 2025-01-07T07:44:09 (UTC +03:00)
source: https://leetcode.com/problems/string-matching-in-an-array/description/?envType=daily-question&envId=2025-01-07
---
Given an array of string `words`, return _all strings in_ `words` _that is a **substring** of another word_. You can return the answer in **any order**.

A **substring** is a contiguous sequence of characters within a string


**Example 1:**

``` Java
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
```


**Example 2:**

``` Java
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
```


**Example 3:**

``` Java
Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.
```

**Constraints:**

-   `1 <= words.length <= 100`
-   `1 <= words[i].length <= 30`
-   `words[i]` contains only lowercase English letters.
-   All the strings of `words` are **unique**.
