package Array;

/**
 * @program: java_algo
 * @description: Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.  You must implement a solution with a linear runtime complexity and use only constant extra space.
 * @author: Ze QIN
 * @create: 2023-09-15 14:11
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        /* sorting Time Complexity O(nlogn), Space Complexity O(1)
        Arrays.sort(nums);
        int l = nums.length;
        int result = nums[l-1];
        int i = 0;
        while(i < l - 2) {
            if (nums[i] == nums[i+1]) {
                i = i+2;
            } else {
                return nums[i];
            }
        }
        return result;*/

        /* Using Hash Map -- Time Complexity O(n), Space Complexity O(n)
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,false));
        }

        for (Map.Entry<Integer, Boolean> entry: map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return Integer.MIN_VALUE;*/

        int result = 0;
        for (int number: nums) {
            result ^= number; // Logical XOR operator 1^1 = 0; 0^0 = 0; 0^1 = 1
        }
        return result;
    }

    public static void main (String[] args) {
        //int[] nums = {1,2,3,1};
        //int[] nums = {1,1,1,3,3,4,3,2,4,2};
        int[] nums = {1,3,1};

        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(nums));
    }
}
