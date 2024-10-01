package tests;

import org.junit.jupiter.api.Test;

import pages.RegistrationPage;

public class StudentRegFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Kate";
    String lastName = "Zhukova";
    String userEmail = "kate@zhukova.ru";
    String userNumber = "8912345678";
    String dayOfBirth = "23";
    String monthOfBirth = "June";
    String yearOfBirth = "2000";
    String subjects = "Math";
    String hobbies = "Music";
    String gender = "Female";
    String picture = "StudentRegForm.jpg";
    String currentAddress = "Moscow, Pushkin street, 1";
    String state = "NCR";
    String city = "Delhi";

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setGenderWrapper(gender)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbiesWrapper(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void SubmitRegistrationTest() {
        registrationPage.openPage().clickSubmit();

        registrationPage.checkNegativeResult();
    }

    @Test
    void incompleteDataEntry() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .clickSubmit();

        registrationPage.checkNegativeResult();
    }
}