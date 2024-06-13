package org.example;
import AnotherClass.*;
public class Main {
    public static void main(String[] args) {
        Pair<Integer, Integer> intPair = new Pair<>(10, 20);
        Pair<String, String> stringPair = new Pair<>("Hello", "World");

        System.out.println("Sum of integer pair: " + PairUtils.sum(intPair));
        System.out.println("Concatenated string pair: " + PairUtils.concatenate(stringPair));
    }
}