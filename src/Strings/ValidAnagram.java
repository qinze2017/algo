package Strings;

import java.util.Arrays;

/**
 * @program: java_algo
 * @description: Given two strings s and t, return true if t is an anagram of s, and false otherwise.  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * @author: Ze QIN
 * @create: 2023-09-26 17:37
 **/
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        /*
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);
        int i = 0;
        if (charS.length == charT.length) {
            while(i < charS.length ) {
                if (charS[i] != charT[i]) return false;
                i++;
            }
            return true;
        }
        return false;
        */

        if (s.length() != t.length()) return false;

        int[] char_counts = new int[26];
        for (int i=0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']++;
        }

        for (int count : char_counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {

        String s = "rat";
        String t = "car";

        ValidAnagram va = new ValidAnagram();
        System.out.print(va.isAnagram(s,t));
    }
}
