---
created: 2024-12-12T23:29:23 (UTC +03:00)
source: https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/?envType=daily-question&envId=2024-12-12
---
You are given an integer array `gifts` denoting the number of gifts in various piles. Every second, you do the following:

-   Choose the pile with the maximum number of gifts.
-   If there is more than one pile with the maximum number of gifts, choose any.
-   Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.

Return _the number of gifts remaining after_ `k` _seconds._


**Example 1:**

``` Java
Input: gifts = [25,64,9,4,100], k = 4
Output: 29
Explanation: 
The gifts are taken in the following way:
- In the first second, the last pile is chosen and 10 gifts are left behind.
- Then the second pile is chosen and 8 gifts are left behind.
- After that the first pile is chosen and 5 gifts are left behind.
- Finally, the last pile is chosen again and 3 gifts are left behind.
The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.
```


**Example 2:**

``` Java
Input: gifts = [1,1,1,1], k = 4
Output: 4
Explanation: 
In this case, regardless which pile you choose, you have to leave behind 1 gift in each pile. 
That is, you can't take any pile with you. 
So, the total gifts remaining are 4.
```


**Constraints:**

-   `1 <= gifts.length <= 10^3`
-   `1 <= gifts[i] <= 10^9`
-   `1 <= k <= 10^3`