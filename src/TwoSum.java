import java.util.HashMap;
import java.util.Map;

/**
 * @program: java_algo
 * @description: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * @author: Ze QIN
 * @create: 2023-09-24 18:35
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;

        /* solution with O(n2)
        for (int i= 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                int sum = target - nums[i];

                if (sum == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        */

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum)) {
                return new int[]{ map.get(sum), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No match found!");
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);

        for(int i = 0; i <= result.length-1; i++){
            System.out.println(result[i]);
        }
    }

}
