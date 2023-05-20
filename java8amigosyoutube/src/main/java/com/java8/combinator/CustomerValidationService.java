package com.java8.combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidationService {
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+0");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 18;
    }

    public boolean isCustomerValid(Customer customer) {
        return isAdult(customer.getDob()) && isEmailValid(customer.getEmail()) && isPhoneNumberValid(customer.getPhoneNumber());
    }
}
