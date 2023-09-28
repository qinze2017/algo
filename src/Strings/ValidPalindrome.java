package Strings;

/**
 * @program: java_algo
 * @description: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.  Given a string s, return true if it is a palindrome, or false otherwise.
 * @author: Ze QIN
 * @create: 2023-09-26 18:01
 **/
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        String value = "";

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                value += c;
            }
        }

        value = value.toLowerCase();

        int begin_pointer = 0;
        int end_pointer = value.length() - 1;

        while (begin_pointer <= end_pointer) {
            if (value.charAt(begin_pointer) != value.charAt(end_pointer)) {
                return false;
            }

            begin_pointer += 1;
            end_pointer -= 1;
        }
        return true;
    }

    public static void main (String[] args) {

        String s = "A man, a plan, a canal: Panama";

        ValidPalindrome vp = new ValidPalindrome();
        System.out.print(vp.isPalindrome(s));
    }
}
