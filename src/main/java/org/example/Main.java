package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Нужно ввести параметры!");
        } else {
            System.out.println("Hello world! " + args[0]);
        }
    }
}
