package TwoPointers;

import java.util.*;

public class TripletSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array first

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++; // Need a bigger number
                } else {
                    right--; // Need a smaller number
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, -1, 2, -3, 1};
        List<List<Integer>> triplets = threeSum(nums);
        System.out.println(triplets);
    }
}
