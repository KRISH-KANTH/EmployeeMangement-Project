import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " | " + name + " | "
                + department + " | " + salary);
    }
}

public class EmployeeManagement {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add employee");
            System.out.println("2. View employees");
            System.out.println("3. Update employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> viewEmployees();
                case "3" -> updateEmployee();
                case "4" -> deleteEmployee();
                case "5" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        employees.add(new Employee(nextId++, name, department, salary));
        System.out.println("Employee added.");
    }

    static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            employee.display();
        }
    }

    static void updateEmployee() {
        System.out.print("Enter employee ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Employee employee : employees) {
            if (employee.id == id) {
                System.out.print("New name: ");
                employee.name = scanner.nextLine();

                System.out.print("New department: ");
                employee.department = scanner.nextLine();

                System.out.print("New salary: ");
                employee.salary = Double.parseDouble(scanner.nextLine());

                System.out.println("Employee updated.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    static void deleteEmployee() {
        System.out.print("Enter employee ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean removed = employees.removeIf(employee -> employee.id == id);
        System.out.println(removed ? "Employee deleted." : "Employee not found.");
    }
}