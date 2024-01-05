package elements;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    String userFullName = faker.name().fullName();
    String mail = faker.internet().emailAddress();
    String address = faker.address().streetAddress();
    String permAddress = faker.address().secondaryAddress();


}
