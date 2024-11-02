---
created: 2024-11-02T13:55:38 (UTC +03:00)
source: https://leetcode.com/problems/circular-sentence/description/?envType=daily-question&envId=2024-11-02
---
A **sentence** is a list of words that are separated by a **single** space with no leading or trailing spaces.

-   For example, `"Hello World"`, `"HELLO"`, `"hello world hello world"` are all sentences.

Words consist of **only** uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.

A sentence is **circular** if:

-   The last character of a word is equal to the first character of the next word.
-   The last character of the last word is equal to the first character of the first word.

For example, `"leetcode exercises sound delightful"`, `"eetcode"`, `"leetcode eats soul"` are all circular sentences. However, `"Leetcode is cool"`, `"happy Leetcode"`, `"Leetcode"` and `"I like Leetcode"` are **not** circular sentences.

Given a string `sentence`, return `true` _if it is circular_. Otherwise, return `false`.


**Example 1:**

``` Java
Input: sentence = "leetcode exercises sound delightful"
Output: true
Explanation: The words in sentence are ["leetcode", "exercises", "sound", "delightful"].
- leetcod_e_'s last character is equal to _e_xercises's first character.
- exercise_s_'s last character is equal to _s_ound's first character.
- soun_d_'s last character is equal to _d_elightful's first character.
- delightfu_l_'s last character is equal to _l_eetcode's first character.
The sentence is circular.
```


**Example 2:**

``` Java
Input: sentence = "eetcode"
Output: true
Explanation: The words in sentence are ["eetcode"].
- eetcod_e_'s last character is equal to _e_etcode's first character.
The sentence is circular.
```


**Example 3:**

``` Java
Input: sentence = "Leetcode is cool"
Output: false
Explanation: The words in sentence are ["Leetcode", "is", "cool"].
- Leetcod_e_'s last character is <strong>not</strong> equal to _i_s's first character.
The sentence is not circular.
```

**Constraints:**

-   `1 <= sentence.length <= 500`
-   `sentence` consist of only lowercase and uppercase English letters and spaces.
-   The words in `sentence` are separated by a single space.
-   There are no leading or trailing spaces.
