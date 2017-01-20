package hackerrank.java.data_structures;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Aleksandr on 20/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-priority-queue
 */
public class JavaPriorityQueue {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        final PriorityQueue<Student> pq = new PriorityQueue<>();
        while (totalEvents > 0) {
            final String event = in.next();

            if ("ENTER".equals(event)) {
                final Student student = new Student(in.next(), in.nextDouble(), in.nextInt());
                pq.add(student);
            } else {
                pq.poll();
            }

            totalEvents--;
        }

        if (pq.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!pq.isEmpty()) {
                System.out.println(pq.poll().getFname());
            }
        }
    }

    private static class Student implements Comparable<Student> {
        private int token;
        private String fName;
        private double cgpa;

        public Student(String fName, double cgpa, int id) {
            super();
            this.token = id;
            this.fName = fName;
            this.cgpa = cgpa;
        }

        public int getToken() {
            return token;
        }

        public String getFname() {
            return fName;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int compareTo(Student o) {
            int result = Double.compare(o.getCgpa(), cgpa);

            if (result == 0) {
                result = fName.compareTo(o.getFname());
            }

            if (result == 0) {
                result = Integer.compare(token, o.getToken());
            }

            return result;
        }
    }
}
