package Q4;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
            return true;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
            return false;
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null; // Remove last element
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(10);

        Employee e1 = new Employee(1, "Alice", "Manager", 75000);
        Employee e2 = new Employee(2, "Bob", "Developer", 60000);
        Employee e3 = new Employee(3, "Charlie", "Designer", 55000);

        system.addEmployee(e1);
        system.addEmployee(e2);
        system.addEmployee(e3);

        System.out.println("Employees after adding:");
        system.traverseEmployees();

        Employee searchResult = system.searchEmployee(2);
        System.out.println("Search result for employeeId 2: " + searchResult);

        system.deleteEmployee(2);
        System.out.println("Employees after deleting employeeId 2:");
        system.traverseEmployees();
    }
}
