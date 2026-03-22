package edu.sorbonne.mimo.library;

import java.util.*;

public class TestPerf {
    public static void main(String[] args) {

        long start = System.nanoTime();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10_000_000; i++) {
            //long uuid = System.currentTimeMillis();
            String uuid = UUID.randomUUID().toString();
            if(i % 100_000 == 0) {
                System.out.println(uuid);
            }
            set.add(uuid);
        }
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println(duration);
        System.out.println("Taille set: " + set.size());

        long startFind = System.nanoTime();

        boolean found = set.contains("abc");

        long endFind = System.nanoTime();

        long durationFind = endFind - startFind;

        System.out.println(found);
        System.out.println(durationFind);
    }
}
