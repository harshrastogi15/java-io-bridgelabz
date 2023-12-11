package employee;

import employee.service.EmployeePayrollService;

public class Main {
    public static void main(String[] args) {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.run();
    }
}
