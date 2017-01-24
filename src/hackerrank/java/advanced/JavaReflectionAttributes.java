package hackerrank.java.advanced;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aleksandr on 23/01/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/java-reflection-attributes
 */
public class JavaReflectionAttributes {
    public static void main(String[] args) {
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for (Method method : methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for (String name : methodList) {
            System.out.println(name);
        }
    }

    private static class Student {

    }
}
