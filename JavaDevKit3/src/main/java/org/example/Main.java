package org.example;
import  AnotherClass.*;
public class Main {
    public static void main(String[] args)
    {
        int a = 5;
        double b = 2.5;
        double sumResult = Calculator.sum(a, b);
        double multiplyResult = Calculator.multiply(a, b);
        double divideResult = Calculator.divide(a, b);
        double subtractResult = Calculator.subtract(a, b);


        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {1, 2, 3, 4, 5};
        Integer[] arr3 = {1, 2, 3, 4, 6};
        System.out.println();
        System.out.println(" Задача 1 ");
        System.out.println();
        System.out.println("Сумма: " + sumResult);
        System.out.println("Умножение: " + multiplyResult);
        System.out.println("Деление: " + divideResult);
        System.out.println("Вычитание: " + subtractResult);

        System.out.println();
        System.out.println(" Задача 2 ");
        System.out.println();
        System.out.println("arr1 и arr2 одинаковы: " + CompareArrays.compareArrays(arr1, arr2));
        System.out.println("arr1 и arr3 одинаковы: " + CompareArrays.compareArrays(arr1, arr3));

        String[] strArr1 = {"Hello", "World"};
        String[] strArr2 = {"Hello", "World"};

        System.out.println("strArr1 и strArr2 одинаковы: " + CompareArrays.compareArrays(strArr1, strArr2));
        System.out.println();
        System.out.println(" Задача 3 ");
        System.out.println();
        Pair<String, Integer> pair1 = new Pair<>("Hello", 10);
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());
        System.out.println(pair1);

        Pair<Double, Boolean> pair2 = new Pair<>(3.14, true);
        System.out.println(pair2);
    }
}