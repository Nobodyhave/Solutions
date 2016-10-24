package hackerrank.tutorial.the_30_days_of_code;

import java.util.Scanner;

/**
 * Created by Aleksandr on 24/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/30-class-vs-instance
 */
public class ClassVsInstance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }
}

class Person {
    private int age;

    public Person(int initialAge) {
        if (initialAge < 0) {
            age = 0;
            System.out.println("Age is not valid, setting age to 0.");
        } else {
            age = initialAge;
        }
    }

    public void amIOld() {
        if (age < 13) {
            System.out.println("You are young.");
        } else if (age >= 18) {
            System.out.println("You are old.");
        } else {
            System.out.println("You are a teenager.");
        }
    }

    public void yearPasses() {
        age++;
    }
}

