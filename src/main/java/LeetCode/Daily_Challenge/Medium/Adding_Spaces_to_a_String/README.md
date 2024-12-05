---
created: 2024-12-03T23:18:42 (UTC +03:00)
source: https://leetcode.com/problems/adding-spaces-to-a-string/description/?envType=daily-question&envId=2024-12-03
---
You are given a **0-indexed** string `s` and a **0-indexed** integer array `spaces` that describes the indices in the original string where spaces will be added. Each space should be inserted **before** the character at the given index.

-   For example, given `s = "EnjoyYourCoffee"` and `spaces = [5, 9]`, we place spaces before `'Y'` and `'C'`, which are at indices `5` and `9` respectively. Thus, we obtain `"Enjoy **_Y_**our _C_offee"`.

Return _the modified string **after** the spaces have been added._


**Example 1:**

``` Java
Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
Output: "Leetcode Helps Me Learn"
Explanation: 
The indices 8, 13, and 15 correspond to the underlined characters in "Leetcode<u><strong>H</strong></u>elps<u><strong>M</strong></u>e<u><strong>L</strong></u>earn".
We then place spaces before those characters.
```


**Example 2:**

``` Java
Input: s = "icodeinpython", spaces = [1,5,7,9]
Output: "i code in py thon"
Explanation:
The indices 1, 5, 7, and 9 correspond to the underlined characters in "i<u><strong>c</strong></u>ode<u><strong>i</strong></u>n<u><strong>p</strong></u>y<u><strong>t</strong></u>hon".
We then place spaces before those characters.
```


**Example 3:**

``` Java
Input: s = "spacing", spaces = [0,1,2,3,4,5,6]
Output: " s p a c i n g"
Explanation:
We are also able to place spaces before the first character of the string.
```


**Constraints:**

-   `1 <= s.length <= 3 * 10^5`
-   `s` consists only of lowercase and uppercase English letters.
-   `1 <= spaces.length <= 3 * 10^5`
-   `0 <= spaces[i] <= s.length - 1`
-   All the values of `spaces` are **strictly increasing**.