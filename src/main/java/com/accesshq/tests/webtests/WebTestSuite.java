package com.accesshq.tests.webtests;

import com.accesshq.tests.ui.FormsPage;
import com.accesshq.tests.ui.States;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebTestSuite extends BaseTestSuite{

    protected FormsPage formsPage;

    @Test
    void TestFormsPageSuccess() {

        //ARRANGE

        // click on menu tab
        menu.clickForms();
        // instantiate forms page
        formsPage = new FormsPage(driver);

        // ACT

        // set name
        String name = "Sikander";

        formsPage.setName(name);
        //set email
        formsPage.setEmail("sikandersandhu82@gmail.com");
        // select state
        formsPage.selectState(States.VIC);
        // click check box
        formsPage.clickAgree();
        // submit form
        formsPage.submitForm();

        // set wait time till pop up appears
        new WebDriverWait(driver, 10).until(d -> formsPage.isPopUpVisible());

        // expected pop up message
        String expected = "Thanks for your feedback " + name;

        // ASSERT

        // check that expected message matched actual pop up message
        // assert that thank you pop-up message appears with the right message
        Assertions.assertEquals(expected, formsPage.createPopUpMessage());

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


// WAIT TIMES

// time consuming approach, very crude as speed matters | last resort
//Thread.sleep(1000);

// more sensible waiting strategy
// look in setup base class | using implicit wait on driver