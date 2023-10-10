import models.Employee;
import services.EmployeeService;
import services.ProductService;
import services.impl.EmployeeServiceImpl;
import services.impl.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeServiceImpl();

        System.out.println("Enter the id: ");
        Long id = scanner.nextLong();
        System.out.println(employeeService.findById(id));

    }
}
