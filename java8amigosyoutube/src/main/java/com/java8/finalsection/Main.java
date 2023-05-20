package com.java8.finalsection;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello("grkjg", "rgjkberg", null);
        hello("jgf" , null, value -> System.out.println("no last name provided"));
        hello2("jgf" , null, () -> System.out.println("no last name provided"));
    }

    static void hello(String firstName , String lastName , Consumer<String> callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName , String lastName , Runnable callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
    /**
     * Callback in Javascript
     *
     * function hello(firstname , lastname , callback) {
     *     console.log(firstname);
     *     if (lastname) {
     *         console.log(lastname);
     *     } else {
     *         callback();
     *     }
     * }
     *
     * To invoke this use hello("afhjvdf" , null , function() {console.log("no last name provided")})
     */
}
