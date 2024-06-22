package AnotherClass;
import java.util.*;

public class EmployeeDirectory {

    private List<Employee> employees;

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }

    // Добавление нового сотрудника в справочник
    public void addEmployee(int employeeNumber, String phoneNumber, String name, int experience) {
        Employee newEmployee = new Employee(employeeNumber, phoneNumber, name, experience);
        employees.add(newEmployee);
    }

    // Поиск сотрудника по стажу
    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    // Поиск сотрудника по имени (возвращает номер телефона)
    public List<String> findPhoneNumbersByName(String name) {
        List<String> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                result.add(employee.getPhoneNumber());
            }
        }
        return result;
    }

    // Поиск сотрудника по табельному номеру
    public Employee findEmployeeByNumber(int employeeNumber) {
        for (Employee employee : employees) {
            if (employee.getEmployeeNumber() == employeeNumber) {
                return employee;
            }
        }
        return null;
    }

}
