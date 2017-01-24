package hackerrank.java.advanced;

import java.security.Permission;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-factory
 */
public class JavaFactoryPattern {
    public static void main(String args[]) {
        Do_Not_Terminate.forbidExit();

        try {

            final Scanner sc = new Scanner(System.in);
            //creating the factory
            FoodFactory foodFactory = new FoodFactory();

            //factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());


            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

    private static class Do_Not_Terminate {

        public static class ExitTrappedException extends SecurityException {

            private static final long serialVersionUID = 1L;
        }

        public static void forbidExit() {
            final SecurityManager securityManager = new SecurityManager() {
                @Override
                public void checkPermission(Permission permission) {
                    if (permission.getName().contains("exitVM")) {
                        throw new ExitTrappedException();
                    }
                }
            };
            System.setSecurityManager(securityManager);
        }
    }

    private interface Food {
        String getType();
    }

    private static class Pizza implements Food {
        public String getType() {
            return "Someone ordered a Fast Food!";
        }
    }

    private static class Cake implements Food {

        public String getType() {
            return "Someone ordered a Dessert!";
        }
    }

    private static class FoodFactory {
        public Food getFood(String order) {
            if ("cake".equals(order)) {
                return new Cake();
            } else if ("pizza".equals(order)) {
                return new Pizza();
            } else {
                throw new IllegalArgumentException("Unknown food type");
            }
        }
    }
}
