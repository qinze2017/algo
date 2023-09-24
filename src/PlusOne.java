/**
 * @program: java_algo
 * @description: You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.  Increment the large integer by one and return the resulting array of digits.
 * @author: Ze QIN
 * @create: 2023-09-24 17:07
 **/
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int l = digits.length;
        for (int i= l -1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {4,9,5};

        PlusOne plus = new PlusOne();
        int[] result = plus.plusOne(nums);

        for(int i = 0; i <= result.length-1; i++){
            System.out.println(result[i]);
        }
    }
}
