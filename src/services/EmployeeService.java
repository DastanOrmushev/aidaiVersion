package services;

import models.Employee;
import models.Receipt;

public interface EmployeeService {


    String addEmployee(String name, int storeId, int age);
    Employee findById(Long id);

}