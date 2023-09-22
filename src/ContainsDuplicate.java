import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: java_algo
 * @description: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * @author: Ze QIN
 * @create: 2023-09-14 19:06
 **/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        int l = nums.length;

        for (int i=0; i<l; i++) {
            if (numbers.contains(nums[i])) return true;
                numbers.add(nums[i]);
        }

        /*Arrays.sort(nums);
        for (int i=0; i<l-1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }*/

        return false;
    }

    public static void main (String[] args) {
        //int[] nums = {1,2,3,1};
        //int[] nums = {1,1,1,3,3,4,3,2,4,2};
        int[] nums = {1,2,3,4};

        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(nums));
    }
}
