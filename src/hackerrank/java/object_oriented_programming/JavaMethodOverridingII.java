package hackerrank.java.object_oriented_programming;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword
 */
public class JavaMethodOverridingII {
    public static void main(String[] args) {
        MotorCycle M = new MotorCycle();
    }

    private static class BiCycle {
        String define_me() {
            return "a vehicle with pedals.";
        }
    }

    private static class MotorCycle extends BiCycle {
        String define_me() {
            return "a cycle with an engine.";
        }

        MotorCycle() {
            System.out.println("Hello I am a motorcycle, I am " + define_me());
            String temp = super.define_me(); //Fix this line
            System.out.println("My ancestor is a cycle who is " + temp);
        }

    }
}
