package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "john", "doe");
        Employee employee2 = new Employee(2, "jane", "smith");
        Employee employee3 = new Employee(1, "john", "doe");
        Employee employee4 = new Employee(3, "emily", "jones");
        Employee employee5 = new Employee(2, "jane", "smith");

        // Sık sık ekleme/silme yapacağımız için LinkedList:
        List<Employee> employees = new LinkedList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        System.out.println(findDuplicates(employees));
        System.out.println(findUniques(employees));
        System.out.println(removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employeeList){
        Set<Integer> uniqueEmployees = new HashSet<>();
        List<Employee> duplicateEmployees= new ArrayList<>();


        for(Employee employee : employeeList){
            if (employee == null) {
                continue;
            }
            int employeeId = employee.getId();
            if (!uniqueEmployees.contains(employeeId)){
                uniqueEmployees.add(employeeId);
            } else {
                duplicateEmployees.add(employee);
            }
        }
        return duplicateEmployees;
    }



    public static Map<Integer, Employee> findUniques( List<Employee> employees){
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee employee : employees){
            if (employee != null){
                uniqueMap.put(employee.getId(), employee);
            }
        }
        return uniqueMap;
    }


    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> result = new ArrayList<>(uniques.values());
        result.removeAll(duplicates);
        return result;
    }

}
