package Strings;

/**
 * @program: java_algo
 * @description: Write a function that reverses a string. The input string is given as an array of characters s.  You must do this by modifying the input array in-place with O(1) extra memory.
 * @author: Ze QIN
 * @create: 2023-09-25 18:49
 **/
public class ReverseString {

    public void reverseString(char[] s) {
        int l = s.length;
        for (int i = 0; i < l/2; i++ ) {
            char temp = s[i];
            s[i] = s[l-1-i];
            s[l-1-i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};

        ReverseString rs = new ReverseString();
        rs.reverseString(s);

        for (int i =0; i< s.length; i++) {
            System.out.print(s[i]);
        }
    }
}
