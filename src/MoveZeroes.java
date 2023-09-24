/**
 * @program: java_algo
 * @description: Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * @author: Ze QIN
 * @create: 2023-09-24 17:57
 **/
public class MoveZeroes {

    public void moveZeroes(int[] nums) {


        if (nums == null || nums.length <= 1) {
            return;
        }

        int l = nums.length;
        int num = 0;

        /* remove the zeros and put non-zero values at begin of array, then add the zero at the end of array
        for (int i =0; i < l; i++) {
            if (nums[i] != 0) {
                nums[num++] = nums[i];
            }
        }

        for (int i = num; i < l; i++) {
            nums[i] =0;
        }*/

        /*Space Complexity : O(1). Only constant space is used. Time Complexity: O(n).*/
        for (int i =0; i < l; i++) {
            if (nums[i] != 0) {
                swap(nums, num++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);

        for(int i = 0; i <= nums.length-1; i++){
            System.out.println(nums[i]);
        }
    }
}
