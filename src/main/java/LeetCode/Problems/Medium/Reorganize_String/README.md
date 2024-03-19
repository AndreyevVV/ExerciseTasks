---
created: 2024-03-19T19:11:00 (UTC +03:00)
source: https://leetcode.com/problems/reorganize-string/description/
---
Given a string `s`, rearrange the characters of `s` so that any two adjacent characters are not the same.

Return _any possible rearrangement of `s` or return `""` if not possible_.


**Example 1:**

``` Java
Input: s = "aab"
Output: "aba"
```


**Example 2:**

``` Java
Input: s = "aaab"
Output: ""
```


**Constraints:**

* `1 <= s.length <= 500`
* `s consists of lowercase English letters`.

---
`Tips:-`

It's easy to realise what we need to do here, alternatively put characters with maximum frequency. The problem lies in implementing this.

Even if you get the intuition of using `Heaps`, it's still a tricky one to implement.

So, the trick is to store pair of `{frequency,char}` in a Heap. Then while `Heap.size()>1` , at every iteration, take out the top two elements, append them to the ans string, decrease their frequency by `1` and push them again in the Heap.

When the loop will break, either the Heap became `empty` or of `1 size.`

If it's empty, return the ans string.

if it has `size == 1`, check the remaining frequency of the top/last element, if its `1`, append it and return ans.

Otherwise, return `""`
