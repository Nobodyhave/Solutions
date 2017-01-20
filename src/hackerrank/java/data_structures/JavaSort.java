package hackerrank.java.data_structures;

import java.util.*;

/**
 * Created by Aleksandr on 20/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-sort
 */
public class JavaSort {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        final List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, new StudentComparator());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }

    private static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int result = Double.compare(s2.getCgpa(), s1.getCgpa());

            if (result == 0) {
                result = s1.getFname().compareTo(s2.getFname());
            }

            if (result == 0) {
                result = Integer.compare(s1.getId(), s2.getId());
            }

            return result;
        }
    }


    private static class Student {
        private int id;
        private String fName;
        private double cgpa;

        public Student(int id, String fName, double cgpa) {
            super();
            this.id = id;
            this.fName = fName;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getFname() {
            return fName;
        }

        public double getCgpa() {
            return cgpa;
        }
    }

}
