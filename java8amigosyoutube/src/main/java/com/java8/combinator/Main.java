package com.java8.combinator;

import com.java8.combinator.CustomerRegistrationValidator.ValidationResult;

import java.time.LocalDate;

import static com.java8.combinator.CustomerRegistrationValidator.isAdult;
import static com.java8.combinator.CustomerRegistrationValidator.isEmailValid;
import static com.java8.combinator.CustomerRegistrationValidator.isPhoneValid;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("anbdv" ,
                "sfewgf@gmail.com",
                "+0726732",
                         LocalDate.of(2000, 10, 12));
        CustomerValidationService customerValidationService = new CustomerValidationService();
        // Without combinator pattern.
        System.out.println(customerValidationService.isCustomerValid(customer));

        // using combinator pattern
        ValidationResult result = isPhoneValid()
                .and(isEmailValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);
    }
}
