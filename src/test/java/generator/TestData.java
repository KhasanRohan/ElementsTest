package generator;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    public String userFullName = faker.name().fullName();
    public String mail = faker.internet().emailAddress();
    public String address = faker.address().streetAddress();
    public String permAddress = faker.address().secondaryAddress();


}
