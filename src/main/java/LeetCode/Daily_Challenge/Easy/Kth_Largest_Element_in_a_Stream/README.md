---
created: 2024-08-12T10:44:06 (UTC +03:00)
source: https://leetcode.com/problems/kth-largest-element-in-a-stream/description/?envType=daily-question&envId=2024-08-12
---
Design a class to find the `k^th` largest element in a stream. Note that it is the `k^th` largest element in the sorted order, not the `k^th` distinct element.

Implement `KthLargest` class:

* `KthLargest(int k, int[] nums)` Initializes the object with the integer `k` and the stream of integers `nums`.
* `int add(int val)` Appends the integer `val` to the stream and returns the element representing the `k^th` largest element in the stream.


**Example 1:**

``` Java
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]
```


**Explanation**

``` Java
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
```


**Constraints:**

* `1 <= k <= 10^4`
* `0 <= nums.length <= 10^4`
* `-10^4 <= nums[i] <= 10^4`
* `-10^4 <= val <= 10^4`
* At most `10^4` calls will be made to `add`.
* It is guaranteed that there will be at least `k` elements in the array when you search for the `k^th` element.


---
At the very beginning, k = 3, the array is \[4, 5, 8, 2\].  
After kthLargest.add(3); the array is \[4, 5, 8, 2, 3\], after sorting, the array is \[2,3,4,5,8\], we count backwards of the array, 3rd largest is 4, it returns 4.  
After kthLargest.add(5); the array is \[4, 5, 8, 2, 3, 5\], after sorting, the array is\[2,3,4,5,5,8\], we count backwards of the array, 3rd largest is 5, it returns 5.  
After kthLargest.add(10); the array is \[4, 5, 8, 2, 3, 5, 10\], after sorting, the array is\[2,3,4,5,5,8,10\], we count backwards of the array, 3rd largest is 5, it returns 5.  
After kthLargest.add(9); the array is \[4, 5, 8, 2, 3, 5, 10, 9\], after sorting, the array is\[2,3,4,5,5,8, 9,10\], we count backwards of the array, 3rd largest is 8, it returns 8.  
After kthLargest.add(4); the array is \[4, 5, 8, 2, 3, 5, 10, 9, 4\], after sorting, the array is\[2,3,4,4,5,5,8, 9,10\], we count backwards of the array, 3rd largest is 8, it returns 8.
