package Array;

public class CountUniqueElements {

    // use the binary search
    public static int unique(int[] arr, int len) {
        int res = 1;
        for (int  i = 1; i < len; i++) {
            int j = 0;
            for (j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }
            if ( i == j) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 12, 10, 9, 45, 2, 10, 10, 45 };
        int len = nums.length;
        System.out.println(unique(nums, len));
    }
}
