package edu.sorbonne.mimo;

import edu.sorbonne.mimo.employee.EmployeeCSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public static void loadData() {

        try {
            Path path = Paths.get("files/employees.csv");
            List<String> lines = Files.readAllLines(path);
            List<EmployeeCSV> employees = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(",");
                String id = parts[0];
                String postalCode = parts[1];
                EmployeeCSV employee = new EmployeeCSV(id, postalCode);
                employees.add(employee);
            }
            System.out.println(employees);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }

    }


}
