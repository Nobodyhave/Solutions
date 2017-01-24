package hackerrank.java.object_oriented_programming;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/calculating-volume
 */
public class CalculatingVolume {
    public static void main(String[] args) {
        DoNotTerminate.forbidExit();
        try {
            Calculate cal = new Calculate();
            int T = cal.get_int_val();
            while (T-- > 0) {
                double volume = 0.0;
                int ch = cal.get_int_val();
                if (ch == 1) {
                    int a = cal.get_int_val();
                    volume = Calculate.do_calc().get_volume(a);
                } else if (ch == 2) {
                    int l = cal.get_int_val();
                    int b = cal.get_int_val();
                    int h = cal.get_int_val();
                    volume = Calculate.do_calc().get_volume(l, b, h);

                } else if (ch == 3) {
                    double r = cal.get_double_val();
                    volume = Calculate.do_calc().get_volume(r);

                } else if (ch == 4) {
                    double r = cal.get_double_val();
                    double h = cal.get_double_val();
                    volume = Calculate.do_calc().get_volume(r, h);

                }
                cal.output.display(volume);
            }

        } catch (NumberFormatException e) {
            System.out.print(e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }


    } //end of main

    private static class DoNotTerminate {

        public static class ExitTrappedException extends SecurityException {
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
    } //end of Do_Not_Terminate

    private static class Calculate {
        private final Scanner in = new Scanner(System.in);
        //private final Scanner in;
        private static final VolumeCalculator vc = new VolumeCalculator();
        public Output output = new Output();

        public Calculate() throws FileNotFoundException {
            //in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        }

        public int get_int_val() {
            return in.nextInt();
        }

        public double get_double_val() {
            return in.nextDouble();
        }

        public static VolumeCalculator do_calc() {
            return vc;
        }

        static class Output {
            public void display(double v) throws IOException {
                System.out.format("%.3f\n", v);
            }
        }

        static class VolumeCalculator {
            public int get_volume(int a) {
                if (a <= 0) {
                    throw new NumberFormatException("All the values must be positive");
                }

                return a * a * a;
            }

            public int get_volume(int l, int b, int h) {
                if (l <= 0 || b <= 0 || h <= 0) {
                    throw new NumberFormatException("All the values must be positive");
                }

                return l * b * h;
            }

            public double get_volume(double r) {
                if (r <= 0) {
                    throw new NumberFormatException("All the values must be positive");
                }

                return 2 * Math.PI * r * r * r / 3;
            }

            public double get_volume(double r, double h) {
                if (r <= 0 || h <= 0) {
                    throw new NumberFormatException("All the values must be positive");
                }

                return Math.PI * r * r * h;
            }
        }
    }
}


