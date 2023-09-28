package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: java_algo
 * @description: Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * @author: Ze QIN
 * @create: 2023-09-25 19:30
 **/
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) {

        String s = "loveleetcode";

        FirstUniqueCharacterInAString fi = new FirstUniqueCharacterInAString();
        System.out.println(fi.firstUniqChar(s));
    }
}
