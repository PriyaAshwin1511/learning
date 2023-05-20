package com.java8.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.java8.combinator.CustomerRegistrationValidator.ValidationResult.EMAIL_INVALID;
import static com.java8.combinator.CustomerRegistrationValidator.ValidationResult.IS_NOT_AN_ADULT;
import static com.java8.combinator.CustomerRegistrationValidator.ValidationResult.PHONE_NUMBER_INVALID;
import static com.java8.combinator.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public interface CustomerRegistrationValidator extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ? SUCCESS: PHONE_NUMBER_INVALID;
    }

    static CustomerRegistrationValidator isPhoneValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ? SUCCESS : EMAIL_INVALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ? SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }
    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_INVALID,
        EMAIL_INVALID,
        IS_NOT_AN_ADULT
    }
}
