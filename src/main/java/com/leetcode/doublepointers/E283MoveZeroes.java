package com.leetcode.doublepointers;


/**
 https://leetcode.com/problems/move-zeroes/

 Given an integer array nums, move all 0's to the end of it while maintaining the relative
 order of the non-zero elements.

 Note that you must do this in-place without making a copy of the array.

 Example 1:
 Input: nums = [0,1,0,3,12]
 Output: [1,3,12,0,0]

 Example 2:
 Input: nums = [0]
 Output: [0]

 Constraints:
 1) 1 <= nums.length <= 104
 2) -231 <= nums[i] <= 231 - 1


 Follow up: Could you minimize the total number of operations done?
*
* */
public class E283MoveZeroes {


    public int[] moveZeroesA(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int len = nums.length;
        int slow = 0, fast = 0;
        while ( fast < len) {
            if (nums[fast] != 0) {
                // only override value 0 element, but not swap
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        // copy all zeros to the end
        while (slow < len) {
            nums[slow] = 0;
            slow++;
        }

        return nums;
    }



    // forward pointers: uses more write operation (same index is wrote more than once)
    public void moveZeroesB(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int slow = 0, fast = 0;
        while ( slow <= len - 2 && fast <= len - 1) {
            while (slow <= len - 2 && nums[slow] != 0) {
                slow++;
            }
            fast = slow + 1;
            while (fast <= len - 1 && nums[fast] == 0) {
                fast++;
            }

            if (slow <= len - 2 && fast <= len - 1) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }

        }
    }

    // This veersion does not maintain the original order
    public void moveZeroesZ(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int right = nums.length - 1;
        int left = 0;

        while (left < right) {
            while (left < right && nums[right] == 0) {
                right--;
            }
            while (left < right && nums[left] != 0) {
                left++;
            }
            if (left < right && nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }

        }
    }
}
