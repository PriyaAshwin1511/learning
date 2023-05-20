package com.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.java8.streams.Gender.FEMALE;
import static com.java8.streams.Gender.MALE;

public class _Streams {
    public static void main(String[] args) {
        System.out.println(args[0]);
        List<Person> personList = Arrays.asList(
                new Person("abcd" , MALE),
                new Person("FEG" , MALE),
                new Person("sdfr" , FEMALE)
        );
        Set<Gender> genders = personList.stream()
                .map(Person::getGender)
                .collect(Collectors.toSet());
        genders.forEach(System.out::println);

        Function<Person, String> personStringFunction = person -> person.getName();

        ToIntFunction<String> stringToIntFunction = name -> name.length();
        IntConsumer println = System.out::println;
        personList.stream()
                .map(personStringFunction)
                .mapToInt(stringToIntFunction)
                .forEach(println);
        Predicate<Person> personPredicate = person -> person.getGender().equals(FEMALE);
        boolean result = personList.stream()
                .allMatch(personPredicate); // all should match.
        boolean res = personList.stream()
                .noneMatch(person -> person.getName().equals("FDSHVS"));

    }
}

class Person {
    private String name;
    private Gender gender;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

enum Gender {
    MALE, FEMALE;
}
