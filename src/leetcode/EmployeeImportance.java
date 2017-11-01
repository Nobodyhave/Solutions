package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aleksandr on 01/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/employee-importance
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        final Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return calculateImportance(map, id);
    }

    private int calculateImportance(Map<Integer, Employee> employees, int id) {
        final Employee e = employees.get(id);

        if (e.subordinates.isEmpty()) {
            return e.importance;
        }

        int importance = e.importance;
        for (Integer sId : e.subordinates) {
            importance += calculateImportance(employees, sId);
        }

        return importance;
    }

    private static class Employee {
        private int id;
        private int importance;
        private List<Integer> subordinates;
    }
}
