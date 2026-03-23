package edu.sorbonne.mimo.library;

import java.util.ArrayList;
import java.util.List;

public class StreamsIntro {
    public static void main(String[] args) {
        List<String> names = List.of("a", "b", "c", "d", "e", "f", "g", "h");
        //Façon impérative
        List<String> upper = new ArrayList<>();
        for (String name : names) {
            String upperCase = name.toUpperCase();
            if(upperCase.startsWith("A")) {
                upper.add(upperCase);
            }
        }

        upper.set(2, "Jean");

        System.out.println(upper);

        //Façon fonctionnelle:
        names.stream()
                .map(name -> name.toUpperCase())
                .filter(name -> name.startsWith("A"))
                .forEach(name -> System.out.println(name));

        List<String> namesUpper = names.stream()
                .map(name -> name.toUpperCase())
                .filter(name -> name.startsWith("A"))
                .toList();
        System.out.println(namesUpper);

    }
}
