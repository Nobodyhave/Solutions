package hackerrank.java.advanced;

/**
 * Created by Aleksandr on 24/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-singleton
 */
public class JavaSingletonPattern {
    private static class Singleton {
        public String str;
        private static final Singleton INSTANCE = new Singleton();

        private Singleton() {

        }

        public static Singleton getSingleInstance() {
            return INSTANCE;
        }
    }
}
