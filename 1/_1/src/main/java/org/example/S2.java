package org.example;

public class S2 {

    private static final String INPUT = "Helloddddddddddddddddddddddddddddddd dawdw adawd awdw  www";

    public static void main(String[] args) {
        String input = "2^12";
        System.out.println(calculatePower(input));


        testString();
        testStringBuilder();

    }

    public static String calculatePower(String input) {
        int index = input.indexOf('^');
        if (index == -1) {
            return "Invalid input: no power symbol (^)";
        }
        try {
            int base = Integer.parseInt(input.substring(0, index));
            int power = Integer.parseInt(input.substring(index + 1));
            int result = (int) Math.pow(base, power);
            return input + " = " + result;
        } catch (NumberFormatException e) {
            return "Invalid input: base or power is not a valid integer";
        }
    }

    private static void testString() {
        long start = System.currentTimeMillis();
        String result = INPUT;
        for (int i = 0; i < 100000; i++) {
            result = result.replace("o", "O");
        }
        long end = System.currentTimeMillis();
        System.out.println("String: " + (end - start) + " ms");
    }

    private static void testStringBuilder() {
        long start = System.currentTimeMillis();
        StringBuilder result = new StringBuilder(INPUT);
        for (int i = 0; i < 100000; i++) {
            int index = result.indexOf("o");
            while (index != -1) {
                result.setCharAt(index, 'O');
                index = result.indexOf("o", index + 1);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end - start) + " ms");
    }








}



