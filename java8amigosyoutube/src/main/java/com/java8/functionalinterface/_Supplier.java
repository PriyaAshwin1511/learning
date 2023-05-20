package com.java8.functionalinterface;

import java.util.function.Supplier;

/**
 * Only returns a value.
 */
public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBUrl.get());
    }

    static Supplier<String> getDBUrl = () -> "testConnectionUrl";
}
