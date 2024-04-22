package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void createStudentAccountTest() {
        //enter personal data
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver)
                .enterPersonalData("Jack", "Sparrow", "jack@gmail.com", "1234567890")
        //select gender(radio button)
                .selectGender("Male")
        //enter birthday
                .enterBirthDay("16 August 1987")
        //enter subjects
                .enterSubjects(new String[]{"Maths","Chemistry"})
        //select hobby(check box)
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("C:/Tools/Toolsqa.jpg")
        //select state
                .selectState("NCR")
        //select city
                .selectCity("Delhi")
        //click on submit button
                .clickOnSubmit()
        //assert student form is appears
        .verifySuccessTitle("Thanks for submitting the form");
    }
}
