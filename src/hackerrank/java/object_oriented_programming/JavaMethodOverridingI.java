package hackerrank.java.object_oriented_programming;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-method-overriding
 */
public class JavaMethodOverridingI {
    public static void main(String[] args) {
        Sports c1 = new Sports();
        Soccer c2 = new Soccer();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
    }

    private static class Sports {

        String getName() {
            return "Generic Sports";
        }

        void getNumberOfTeamMembers() {
            System.out.println("Each team has n players in " + getName());
        }
    }

    private static class Soccer extends Sports {
        @Override
        String getName() {
            return "Soccer Class";
        }

        void getNumberOfTeamMembers() {
            System.out.println("Each team has 11 players in " + getName());
        }
    }
}
