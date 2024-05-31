package org.example;

public class Main {
    public static void main(String[] args) {
        String message = createMessage(args);
        System.out.println(message);
    }

    public static String createMessage(String[] args) {
        return args.length == 0
                ? "Нужно ввести параметры!"
                : "Hello world! " + args[0];
    }
}
