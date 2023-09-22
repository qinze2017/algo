import java.util.Arrays;

/**
 * @program: java_algo
 * @description: sort Array
 * @author: Ze QIN
 * @create: 2023-09-14 12:19
 **/
public class Remove_duplicates_Array {
    public static int removeDuplicates(int nums[])
    {
        int l = nums.length;
        if (l == 0 || l == 1) {
            return l;
        }

        int[] expectedNums = new int[l];
        int j = 0;

        for (int i=0; i<l-1; i++) {
            if (nums[i] != nums[i+1]) {
                expectedNums[j++] = nums[i];
            }
        }
        expectedNums[j++] = nums[l -1];

        // Changing original array
        for (int i=0; i<j; i++) {
            nums[i] = expectedNums[i];
        }

        return j;
    }



    public static void main (String[] args){
        int nums[] = {1,1,2,2,3};

        Arrays.sort(nums);

        int length = removeDuplicates(nums);

        //printing array elements
        for (int i=0; i<length; i++)
            System.out.print(nums[i]+" " +"\n");

        int k = 0;
        System.out.println("Post-Increment");
        System.out.println(k++);

        int o = 0;
        System.out.println("Pre-Increment");
        System.out.println(++o);
    }

}
