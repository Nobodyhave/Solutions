package hackerrank.tutorial.the_30_days_of_code;

/**
 * Created by Aleksandr on 10/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-generics
 */
public class Generics {
    private static <T> void printArray(T[] array) {
        for (T elem : array) {
            System.out.println(elem);
        }
    }

    public static void main(String args[]) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        printArray(intArray);
        printArray(stringArray);

        if (Generics.class.getDeclaredMethods().length > 2) {
            System.out.println("You should only have 1 method named printArray.");
        }
    }
}
