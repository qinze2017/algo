import java.lang.reflect.Method;

/**
 * @program: java_algo
 * @description: Reflection is a feature in the Java programming language.
 * It allows an executing Java program to examine or "introspect" upon itself,
 * and manipulate internal properties of the program.
 * For example, it's possible for a Java class to obtain the names of all its members and display them.
 * @author: Ze QIN
 * @create: 2023-09-15 15:40
 **/
public class JavaReflection {
    public static void main(String args[])
    {
        try {
            Class c = Class.forName(args[0]);
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}
