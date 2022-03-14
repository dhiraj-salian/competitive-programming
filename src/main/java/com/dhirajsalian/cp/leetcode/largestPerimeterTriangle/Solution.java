// Problem: https://leetcode.com/problems/largest-perimeter-triangle/

package com.dhirajsalian.cp.leetcode.largestPerimeterTriangle;

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int last = nums.length - 1, perimeter;
        do {
            perimeter = nums[last] + nums[last - 1] + nums[last - 2];
            if (checkValidSide(perimeter, nums[last])
                    && checkValidSide(perimeter, nums[last - 1])
                    && checkValidSide(perimeter, nums[last - 2])) {
                return perimeter;
            }
            last--;
        } while (last >= 2);
        return 0;
    }

    private boolean checkValidSide(int perimeter, int side) {
        return perimeter - side > side;
    }
}
