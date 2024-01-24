/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(twoSum(new int[] {2, 7, 11, 15}, 9)); // [0,1]
        System.out.println(twoSum(new int[] {3, 2, 4}, 6)); // [1,2]
        System.out.println(twoSum(new int[] {3, 3}, 6)); // [0,1]
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int x = 1; x < nums.length; x++) {
            for (int i = 0; i + x < nums.length; i++) {
                if (nums[i + x] + nums[i] == target) {
                    return new int[]{i, x + i};
                }
            }
        }

        return new int[]{};
    }

}
