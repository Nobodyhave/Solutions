package hackerrank.java.data_structures;

import java.lang.reflect.Method;

/**
 * Created by Aleksandr on 20/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-generics
 */
public class JavaGenerics {
    public static void main(String args[]) {
        final Printer myPrinter = new Printer();
        final Integer[] intArray = {1, 2, 3};
        final String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            final String name = method.getName();

            if (name.equals("printArray"))
                count++;
        }

        if (count > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }

    private static class Printer {
        public <T> void printArray(T[] a) {
            for (T e : a) {
                System.out.println(e);
            }
        }
    }
}
