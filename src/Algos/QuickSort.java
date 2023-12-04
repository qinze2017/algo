package Algos;

public class QuickSort {

    public static int partition(int[] arr, int left, int right) {
        int pivotKey
    }

    public static void quickSort(int[] arr, int left, int right) {

        if (left >= right) return;;
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {5,3,8,6,4};
        // O (n^2)
        sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
