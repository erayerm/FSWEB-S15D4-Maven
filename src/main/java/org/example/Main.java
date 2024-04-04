package org.example;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?")); //true
        System.out.println(checkForPalindrome("Racecar")); //true
        System.out.println(checkForPalindrome("hello")); //false
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?")); //true
        System.out.println(checkForPalindrome("Test")); //false
        System.out.println(checkForPalindrome("Welcome")); //false

        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(7));
        System.out.println(convertDecimalToBinary(8));
    }

    public static boolean checkForPalindrome(String text) {
        char[] words = text
                .replaceAll("[-.,?!_'\"]", "").replace(" ", "")
                .toLowerCase(Locale.ENGLISH).toCharArray();
        List<Character> stack = new ArrayList<>();

        boolean isEven = words.length % 2 == 0;
        int mid = isEven ? words.length / 2 : (words.length - 1) / 2;
        for (int i = 0; i < words.length; i++) {
            if (!isEven && i == mid)
                continue;
            if (i < mid) {
                stack.add(words[i]);
                continue;
            }
            if (stack.get(stack.size() - 1) == words[i])
                stack.remove(stack.size() - 1);
        }
        return stack.isEmpty();
    }

    //5 - 101
    //6 - 110 6%2=0 3%2=1 1%2=1

    public static String convertDecimalToBinary(int number) {
        List<Integer> numList = new ArrayList<>();
        while (true) {
            if (number == 0) break;
            numList.add(0, number % 2);
            number /= 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer value : numList) {
            stringBuilder.append(value);
        }

        return stringBuilder.toString();
        //return String.valueOf(findBinary(number));
    }

    /*
    public static int findBinary(int num) {
        if (num > 1)
            return num % 2 + 10 * findBinary(num / 2);
        return num;
    }
     */
}