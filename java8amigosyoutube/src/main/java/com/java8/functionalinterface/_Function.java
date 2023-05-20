package com.java8.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        Function<Integer, Integer> function = add.andThen(multiply);
        System.out.println(function.apply(10));
        System.out.println(addMultiply.apply(1,10));

    }

    static Function<Integer, Integer> multiply = number -> number*10;
    static Function<Integer, Integer> add = number -> number+1;

    static BiFunction<Integer, Integer, Integer> addMultiply = (x,y) -> (x+1) * y;
}
