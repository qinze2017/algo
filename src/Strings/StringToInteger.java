package Strings;

/**
 * @program: java_algo
 * @description: mplement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function)
 * @author: Ze QIN
 * @create: 2023-09-26 18:48
 **/
public class StringToInteger {

    public int myAtoi(String s) {

        int l = s.length();
        int i = 0;
        int sign = 1;

        //account 0
        while (i < l && s.charAt(i) == ' ') {
            i++;
        }

        if (i > l) return 0;

        //account sign
        if (i < l && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        int num = 0;

        // limit
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }

                num = num * 10 + (s.charAt(i++) - '0');
        }

        return num * sign;
    }

    public static void main (String[] args) {

        String s = "-4193 with words";

        StringToInteger sti = new StringToInteger();
        System.out.print(sti.myAtoi(s));
    }
}
