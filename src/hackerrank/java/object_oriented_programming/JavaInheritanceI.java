package hackerrank.java.object_oriented_programming;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-inheritance-1
 */
public class JavaInheritanceI {
    public static void main(String args[]) {

        final Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
    }

    private static class Animal {
        void walk() {
            System.out.println("I am walking");
        }
    }

    private static class Bird extends Animal {
        void fly() {
            System.out.println("I am flying");
        }

        void sing() {
            System.out.println("I am singing");
        }
    }
}
