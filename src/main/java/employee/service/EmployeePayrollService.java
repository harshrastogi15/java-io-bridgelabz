package employee.service;


import employee.utility.Employee;

import java.io.*;

public class EmployeePayrollService {
    /**
     * Method to read employee details from the console
     */
    public void run() {
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Employee Details:");
            System.out.print("Enter Employee ID: ");
            int id = Integer.parseInt(reader.readLine());

            System.out.print("Enter Employee Name: ");
            String name = reader.readLine();

            System.out.print("Enter Employee Salary: ");
            double salary = Double.parseDouble(reader.readLine());

            Employee employee = new Employee(id, name, salary);

            System.out.println("\nEmployee Details:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Salary: " + employee.getSalary());

            writePayrollToFile(employee);
        } catch (IOException e) {
            System.out.println("Console error");
        }
    }


    /**
     * UC-4
     * Method to write payroll into the file
     *
     * @param employee
     */
    public void writePayrollToFile(Employee employee){
        try {
            FileWriter fileReader = new FileWriter("payroll.txt",true);
            fileReader.write(employee.getId() + ", " +employee.getName() + ", " + employee.getSalary() + '\n');
            fileReader.close();
        }catch (IOException e) {
            System.out.println(e);
            System.out.println("File Not Found");
        }
    }
}