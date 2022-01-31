package com.accesshq.tests.webtests;

import com.accesshq.tests.ui.FormsPage;
import com.accesshq.tests.ui.States;
import org.junit.jupiter.api.*;


public class WebTestSuite extends BaseTestSuite{

    protected FormsPage formsPage;

    @Test
    void TestFormsPageSuccess() {
        // click on menu tab
        menu.clickForms();
        // instantiate forms page
        formsPage = new FormsPage(driver);
        // set name
        formsPage.setName("Sikander");
        //set email
        formsPage.setEmail("sikandersandhu82@gmail.com");
        // select state
        formsPage.selectState(States.VIC);
        // click check box
        formsPage.clickAgree();
        // submit form
        formsPage.submitForm();
    }

    // Leave all field blank. Only click submit
    @Test
    void TestFormPageFail(){

        // click forms tab
        menu.clickForms();

        // create FormsPage object to access functionality
        formsPage = new FormsPage(driver);

        // submit form to reveal errors
        formsPage.submitForm();

        // assert the error messages | name, email , check box
        Assertions.assertEquals("Your name is required", formsPage.getErrorMessageName());
        Assertions.assertEquals("Your email is required", formsPage.getErrorMessageEmail());
        Assertions.assertEquals("You must agree to continue", formsPage.getErrorMessageCheckBox());

    }
}