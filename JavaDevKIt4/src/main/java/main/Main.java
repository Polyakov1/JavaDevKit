package main;
import java.util.*;
import AnotherClass.*;


public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        // Добавление сотрудников
        directory.addEmployee(1234, "123-456-7890", "John Doe", 5);
        directory.addEmployee(5678, "987-654-3210", "Jane Doe", 3);

        // Поиск по стажу
        List<Employee> experiencedEmployees = directory.findEmployeesByExperience(5);
        System.out.println("Сотрудники со стажем 5 лет:");
        for (Employee employee : experiencedEmployees) {
            System.out.println(employee.getName() + " - " + employee.getPhoneNumber());
        }

        // Поиск по имени
        List<String> phoneNumbers = directory.findPhoneNumbersByName("John Doe");
        System.out.println("\nНомер телефона для John Doe:");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }

        // Поиск по табельному номеру
        Employee employee = directory.findEmployeeByNumber(1234);
        if (employee != null) {
            System.out.println("\nСотрудник с табельным номером 1234: " + employee.getName());
        } else {
            System.out.println("\nСотрудник с таким табельным номером не найден.");
        }
    }
}

