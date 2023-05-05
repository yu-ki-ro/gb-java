package org.example;

import java.util.Arrays;
import java.util.Random;

public class S1 {

    public static void main(String[] args){

        int i = new Random().nextInt(2001);
        int n = getHighestBitPosition(i);
        int[] m1 = getMultiplesOfNInRange(i, Short.MAX_VALUE, n);
        int[] m2 = getNonMultiplesOfNInRange(Short.MIN_VALUE, i, n);



        System.out.println("Случайное число i: " + i);
        System.out.println("Номер старшего значащего бита числа i: " + n);
        System.out.println("Кратные числа: " + Arrays.toString(m1));
        System.out.println("Некратные числа: " + Arrays.toString(m2));
    }

    private static int getHighestBitPosition(int num) {
        int position = 0;
        while (num != 0) {
            position++;
            num >>>= 1;
        }
        return position;
    }

    private static int[] getMultiplesOfNInRange(int start, int end, int n) {
        int[] multiples = new int[(end - start) / n + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (i % n == 0) {
                multiples[index++] = i;
            }
        }
        return Arrays.copyOf(multiples, index);
    }

    private static int[] getNonMultiplesOfNInRange(int start, int end, int n) {
        int numNonMultiples = 0;
        for (int i = start; i <= end; i++) {
            if (i % n != 0) {
                numNonMultiples++;
            }
        }
        if (numNonMultiples == 0) {
            return new int[0];
        }
        int[] nonMultiples = new int[numNonMultiples];
        int index = 0;
        for (int i = start; i <= end && index < nonMultiples.length; i++) {
            if (i % n != 0) {
                nonMultiples[index++] = i;
            }
        }
        return nonMultiples;
    }


}
