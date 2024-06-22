package AnotherClass;

public class Employee {
    private int employeeNumber;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int employeeNumber, String phoneNumber, String name, int experience) {
        this.employeeNumber = employeeNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}