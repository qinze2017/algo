package Strings;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

/**
 * @program: java_algo
 * @description: An exercise
 * @author: Ze QIN
 * @create: 2023-11-02 12:00
 **/
public class Convert {

    static public void main (String[] args) {
        //(a+b)square = ((a*a) + 2ab + b*b))
        int a = 20;
        float b = 42.159f;
        double value = a*a + 2*(a*b) + b*b;

        System.out.print(value);
    }
}
