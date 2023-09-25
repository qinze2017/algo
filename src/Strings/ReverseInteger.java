package Strings;

/**
 * @program: java_algo
 * @description: Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * @author: Ze QIN
 * @create: 2023-09-25 19:05
 **/
public class ReverseInteger {

    public int reverse(int x) {
        int last;
        int result = 0;

        while(x != 0) {
            last = x % 10;
            x /= 10;

            /*Integer.MAX_VALUE is equal 2147483647. Integer.MIN_VALUE is equal  -2147483648.
            Last digits are 7 and 8. This is the reason why we check  pop>7 and pop < -8 conditions*/
            if (result > Integer.MAX_VALUE/10 || result == Integer.MIN_VALUE/10 && last > 7) return 0;
            if (result < Integer.MIN_VALUE/10 || result == Integer.MAX_VALUE/10 && last < -8) return 0;

            result = (result * 10) + last;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 123;

        ReverseInteger ri = new ReverseInteger();
        System.out.print(ri.reverse(x));
    }
}
