package com.java8.functionalinterface;

import java.util.function.Predicate;

/**
 * Evaluates to a boolean value.
 */
public class _Predicate {
    public static void main(String[] args) {
        Predicate<String> predicate = (number) -> isValid(number);
        System.out.println(predicate.test("6744"));
        predicate.and((number) -> number.length() > 3).test("4546");
    }

    static boolean isValid(String phoneNumber) {
        return phoneNumber.length() > 5;
    }
}
