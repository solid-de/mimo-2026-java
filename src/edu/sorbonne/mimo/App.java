package edu.sorbonne.mimo;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {


        Set<String> values = new HashSet<>();
        values.add("A");
        values.add("Z");
        values.add("T");
        boolean addedT = values.add("T");
        System.out.println(addedT);
        values.add("t");
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("-----------");
        EmployeeService.loadData();
    }




}
