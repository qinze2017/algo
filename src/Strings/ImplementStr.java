package Strings;

/**
 * @program: java_algo
 * @description: Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @author: Ze QIN
 * @create: 2023-09-28 09:32
 **/
public class ImplementStr {

    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        if (haystack == null || needle == null) return -1;

        if (haystack.equals(needle)) return 0;

        /*for (int i = 0; i < h - n + 1;  i++) {
            if (haystack.substring(i, i + n).equals(needle)) return i;
        }*/

        for (int i = 0; i < h - n + 1;  i++) {
            int j = 0;
            for (; j< n; j ++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                     break;
                }
            }

            if (j == n) {
                return i;
            }
        }

        return -1;
    }

    public static void main (String[] args) {

        String haystack = "sadbutsad";
        String needle = "sad";

        ImplementStr is = new ImplementStr();
        System.out.print(is.strStr(haystack, needle));
    }
}
