package edu.sorbonne.mimo;

import edu.sorbonne.mimo.employee.EmployeeCSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService {

    public static void loadData() {

        try {
            Path path = Paths.get("files/employees.csv");
            List<String> lines = Files.readAllLines(path);

            //Afficher codes postaux uniques
            List<String> postalCodes = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(",");
                if(parts.length == 0) {
                    continue;
                }
                String id = parts[0];

                String postalCode;
                if(parts.length == 1) {
                    postalCode = "9999";
                } else {
                    postalCode = parts[1];
                }
                if(postalCodes.contains(postalCode)) {
                    continue;
                }
                postalCodes.add(postalCode);


            }
            System.out.println(postalCodes);

            //Compter par code postal
            Map<String, Integer> employeesByPostalCode = new HashMap<>();

            for (String line : lines) {
                String[] parts = line.split(",");
                if(parts.length == 0) {
                    continue;
                }
                String id = parts[0];

                String postalCode;
                if(parts.length == 1) {
                    postalCode = "9999";
                } else {
                    postalCode = parts[1];
                }
                Integer existingCount = employeesByPostalCode.get(postalCode);
                if(existingCount != null) {
                    int newCount = existingCount + 1;
                    employeesByPostalCode.put(postalCode, newCount);
                } else {
                    employeesByPostalCode.put(postalCode, 1);
                }

            }
            System.out.println(employeesByPostalCode);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);

        }

    }


}
