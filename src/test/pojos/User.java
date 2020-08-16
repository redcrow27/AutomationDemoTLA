package pojos;


import base.BaseTest;
import com.github.javafaker.Faker;

public class User extends BaseTest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    Faker faker = new Faker();

    public User() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        phoneNumber = faker.phoneNumber().cellPhone();
        email = faker.internet().emailAddress();
    }

    public User(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
