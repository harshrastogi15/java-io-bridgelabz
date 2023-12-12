package employee.service;


import employee.utility.Employee;

import java.io.*;
import java.util.Scanner;

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
            countEntriesFile();
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
            FileWriter fileWriter = new FileWriter("file\\payroll.txt",true);
            fileWriter.write(employee.getId() + ", " +employee.getName() + ", " + employee.getSalary() + '\n');
            fileWriter.close();
        }catch (IOException e) {
            System.out.println(e);
            System.out.println("File Not Found");
        }
    }


    /**
     * UC-5
     * count entries in file
     */
    public void countEntriesFile(){
        try {
            File myObj = new File("file\\payroll.txt");
            Scanner read = new Scanner(myObj);
            int entries=0;
            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
                entries ++;
            }

            System.out.println("Total Entries in file: "+ entries);
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

}