package Strings;

import java.util.Arrays;

/**
 * @program: java_algo
 * @description: Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * @author: Ze QIN
 * @create: 2023-09-28 17:18
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int l = strs.length;

        /*The idea is to sort the array of strings and find the common prefix of the first and last string of the sorted array.
        Time Complexity: O(MAX * n * log n ) where n is the number of strings in the array and MAX is the maximum number of characters in any string.
        Please note that comparison of two strings would take at most O(MAX) time, and for sorting n strings, we would need O(MAX * n * log n ) time.
        Auxiliary Space: O(1)
        if (l == 0) return "";

        if (l == 1) return strs[0];

        //sort the strings, find the two with most differents
        Arrays.sort(strs);

        //find the min length
        int minl = Math.min(strs[0].length(), strs[l-1].length());

        int i = 0;

        while(i < minl && strs[0].charAt(i) == strs[l-1].charAt(i)) i++;

        String pre = strs[0].substring(0,i);*/

        /*The Idea is to find unique prefix without sorting the string array.
        Extract substring by comparing current substring with the previous substring and update it’s result.
        For large string it work much faster.*/
        String pre = strs[0];

        for (int i = 1; i < l; i++) {
            while(strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);

                if (pre.isEmpty()) {
                    return "";
                }
            }
        }

        return pre;
    }

    public static void main (String[] args) {

        String[] strs = {"dog","racecar","car"};

        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.print(lcp.longestCommonPrefix(strs));
    }
}
