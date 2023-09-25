package Array;

/**
 * @program: java_algo
 * @description: Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * @author: Ze QIN
 * @create: 2023-09-14 15:51
 **/
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int l = nums.length;
        //k = k%l;

        int[] rotate = new int[l];
        //int j = 0;

        for(int i = 0; i <= l-1; i++){
            rotate[(i+k) % l] = nums[i];
        }


        /* method 1
        for (int i = l-k; i < l; i++) {
            rotate[j++] = nums[i];
        }

        for ( int i = 0; i < l-k; i++) {
            rotate[i+k] = nums[i];
        }*/

        /* method 2
        for (int i = 0; i < l ; i++) {
            if (i < l - k) {
                rotate[i+k] = nums[i];
            } else {
                rotate[j++] = nums[i];
            }
        }*/

        // Changing original array
        for(int i=0; i < l; i++) {
            nums[i] = rotate[i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        int l = nums.length;
        int rotateLength = k%l -1;
        int begin = 0;
        int end = l-1;
        int len = l-1;
        int[] rotate = new int[l];
        int[] rotateFinal = new int[l];

        for (int i =0; i < l ; i++ ) {
            rotate[end--] = nums[i];
        }

        for(int i=0; i < l; i++) {
            System.out.print(rotate[i]+" " + "\n");
        }

        while(begin < l){
            if (begin <= k%l -1) {
                rotateFinal[begin] = rotate[rotateLength--];
            } else {
                rotateFinal[begin] = rotate[len--];
            }
            begin++;
        }

        // Changing original array
        for(int i=0; i < l; i++) {
            nums[i] = rotateFinal[i];
        }
    }

    public static void main (String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        //int[] nums = {1,2,3};4
        //int[] nums = {1,2};3
        int k = 3;

        rotate(nums, k);
        //rotate2(nums, k);

        //printing array elements
        for (int i=0; i<nums.length; i++)
            System.out.print(nums[i]+" ");

    }

}
