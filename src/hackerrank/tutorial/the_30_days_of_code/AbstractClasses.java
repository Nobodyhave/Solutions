package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 01/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-abstract-classes
 */
public class AbstractClasses {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final String title = in.nextLine();
        final String author = in.nextLine();
        final int price = in.nextInt();
        final Book newNovel = new MyBook(title, author, price);
        newNovel.display();

    }

    private static abstract class Book {
        String title;
        String author;

        Book(String t, String a) {
            title = t;
            author = a;
        }

        abstract void display();
    }

    private static class MyBook extends Book {
        private int price;

        public MyBook(String t, String a, int p) {
            super(t, a);

            price = p;
        }

        @Override
        void display() {
            System.out.format("Title: %s\nAuthor: %s\nPrice: %d", title, author, price);
        }
    }
}
