package hackerrank.java.advanced;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-annotations
 */
public class JavaAnnotations {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String role = in.next();
            int spend = in.nextInt();
            try {
                Class annotatedClass = FamilyMember.class;
                final Method[] methods = annotatedClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(FamilyBudget.class)) {
                        FamilyBudget family = method
                                .getAnnotation(FamilyBudget.class);
                        String userRole = family.userRole();
                        int budgetLimit = family.budgetLimit();
                        if (userRole.equals(role)) {
                            if (spend <= budgetLimit) {
                                method.invoke(FamilyMember.class.newInstance(),
                                        budgetLimit, spend);
                            } else {
                                System.out.println("Budget Limit Over");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            testCases--;
        }
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface FamilyBudget {
        String userRole() default "GUEST";

        int budgetLimit();
    }

    private static class FamilyMember {
        @FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
        public void seniorMember(int budget, int moneySpend) {
            System.out.println("Senior Member");
            System.out.println("Spend: " + moneySpend);
            System.out.println("Budget Left: " + (budget - moneySpend));
        }

        @FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
        public void juniorUser(int budget, int moneySpend) {
            System.out.println("Junior Member");
            System.out.println("Spend: " + moneySpend);
            System.out.println("Budget Left: " + (budget - moneySpend));
        }
    }
}
