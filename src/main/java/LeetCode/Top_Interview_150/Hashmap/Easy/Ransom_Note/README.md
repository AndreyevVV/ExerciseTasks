---
created: 2023-09-29T22:59:03 (UTC +02:00)
source: https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
---
Given two strings `ransomNote` and `magazine`, return `true` _if_ `ransomNote` _can be constructed by using the letters from_ `magazine` _and_ `false` _otherwise_.

Each letter in `magazine` can only be used once in `ransomNote`.

**Example 1:**

```
Input: ransomNote = "a", magazine = "b"
Output: false

```

**Example 2:**

```
Input: ransomNote = "aa", magazine = "ab"
Output: false

```

**Example 3:**

```
Input: ransomNote = "aa", magazine = "aab"
Output: true

```

**Constraints:**

-   `1 <= ransomNote.length, magazine.length <= 10^5`
-   `ransomNote` and `magazine` consist of lowercase English letters.
