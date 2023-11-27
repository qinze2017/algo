package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: java_algo
 * @description:
 * @author: Ze QIN
 * @create: 2023-11-08 17:50
 **/
public class ReverseEventNumbers {

    public static void  reverseEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();

        // Filter and remove even numbers
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                evenNumbers.add(numbers.get(i));
            }
        }

        // Reverse the list of even numbers
        Collections.reverse(evenNumbers);

        // Insert reversed even numbers back into the original list
        int evenIndex = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.set(i, evenNumbers.get(evenIndex));
                evenIndex++;
            }
        }
    }

    public static void main( String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        reverseEvenNumbers(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}
