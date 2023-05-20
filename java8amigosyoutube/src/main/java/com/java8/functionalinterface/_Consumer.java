package com.java8.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Takes an argument and returns no result.
 */
public class _Consumer {
    public static void main(String[] args) {
        Customer customer = new Customer("abcd", "98623745765");
        Consumer<Customer> consumer = Customer::printCustomer;
        consumer.accept(customer);
        BiConsumer<Customer, Boolean> biConsumer = (cust , showPhoneNumber) -> System.out.println(cust + " "+showPhoneNumber);
        biConsumer.accept(customer, true);

    }
    static class Customer {
        private String name;
        private String number;

        Customer(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public void printCustomer() {
            System.out.println( this.name +" "+this.number);
        }
    }
}


