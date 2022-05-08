# Double pointers

![Alt text](images/double-pointers.png?raw=true "Double Pointers")

* this method can only againt SORTED array

## 相向双指针的分类
* Reverse 型
    * [Reverse String](src/main/java/com/leetcode/doublepointers/E344ReverseString.java)
    * [Valid Palindrome](src/main/java/com/leetcode/doublepointers/E125ValidatePalindrome.java)
    * [Valid Palindrome II](src/main/java/com/leetcode/doublepointers/E680ValidatePalindromeII.java)

* Two Sum 型
    * [Two Sum](src/main/java/com/leetcode/doublepointers/E001TwoSum.java)
    * [Three Sum](src/main/java/com/leetcode/doublepointers/M015ThreeSum.java)

* Partition 型
    * [Quick Sort](src/main/java/com/sorting/QuickSort.java)
    * [Sort Colors](src/main/java/com/leetcode/doublepointers/M075SortColors.java)


* 哈希表的实现方法
    * 时间复杂度 O(n)
    * 空间复杂度 O(n)


* 排序 + 双指针
    * 时间复杂度 O(nlogn)
    * 空间复杂度 O(1)
    * 注意空间复杂度一般指额外空间复杂度 即不包含输入和输出

#### Partition
* no extra place: do it in-place

```python
while left <= right:
    while left <= right and nums[left] should be at left side
        left++;
    while left <= right and nums[right] should be at right side
        right--;
    
    if left <= right:
        swap(left, right)
        left++;
        right--;
```



其他有趣的排序
烙饼排序 Pancake Sort(有可能会考哦) https://en.wikipedia.org/wiki/Pancake_sorting http://www.geeksforgeeks.org/pancake-sorting/
睡眠排序 Sleep Sort https://rosettacode.org/wiki/Sorting_algorithms/Sleep_sort
面条排序 Spaghetti Sort https://en.wikipedia.org/wiki/Spaghetti_sort
猴子排序 Bogo Sort https://en.wikipedia.org/wiki/Bogosort





## 同向双指针