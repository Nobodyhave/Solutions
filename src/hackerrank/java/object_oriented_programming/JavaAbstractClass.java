package hackerrank.java.object_oriented_programming;

import java.util.Scanner;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-abstract-class
 */
public class JavaAbstractClass {
    public static void main(String[] args) {
        //Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
        final Scanner sc = new Scanner(System.in);
        final String title = sc.nextLine();
        final MyBook newNovel = new MyBook();
        newNovel.setTitle(title);
        System.out.println("The title is: " + newNovel.getTitle());
        sc.close();

    }

    private static abstract class Book {
        String title;

        abstract void setTitle(String s);

        String getTitle() {
            return title;
        }
    }

    private static class MyBook extends Book {
        @Override
        public void setTitle(String s) {
            title = s;
        }
    }
}
