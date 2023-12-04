package Algos;

public class InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int  i = 1; i < arr.length; i++) {
            int  j = i;
            int target = arr[i];
            System.out.print("target is " + target + "\n");

            while(j > 0 && target < arr[j - 1]) {
                System.out.print("j is " + j + " and arr[j] is " + arr[j] + " and arr[j-1] is " + arr[j-1] + "\n");
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,8,6,4};
        // O (n^2)
        insertSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
