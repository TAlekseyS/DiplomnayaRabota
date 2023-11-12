package ru.netology.Dannie;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGeneratorInfo {

    public static String getPasteApprovedCard() {
        return "4444 4444 4444 4441";
    }


    public static String getPasteNextYear() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getPasteVladelec() {
        Faker faker = new Faker((new Locale("en")));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getPasteCVC() {
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        return fakeValuesService.numerify("###");
    }


}