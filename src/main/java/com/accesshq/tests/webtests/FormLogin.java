package com.accesshq.tests.webtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormLogin {

    private final String EXPECT_TITLE = " Forms ";
    protected WebDriver driver;
    private enum States {NSW, VIC, QLD, NT, SA, WA}

    // name | <input name="name" required="required" id="name" type="text" xpath="1">
    By nameBy = By.id("name");

    // email | <input name="email" required="required" id="email" type="text" xpath="1">
    By emailBy = By.id("email");

    // state | <div class="v-select__selections" xpath="1"></div>
    By stateBy = By.cssSelector(".v-select__selections");

    // checkbox | <div class="v-input--selection-controls__ripple" xpath="1"></div>
    By checkBoxBy = By.cssSelector(".v-input--selection-controls__ripple");

    // submit button | <span class="v-btn__content" xpath="1"></span>
    By submitBtnBy = By.xpath("//span[normalize-space()='submit']");

    // clear button | <span class="v-btn__content" style="" xpath="1">clear</span>
    By clearBtnBy = By.xpath("//span[normalize-space()='clear']");

    // Traditional layout | <div tabindex="0" aria-selected="false" role="tab" class="v-tab" xpath="1">Traditional</div>
    By traditionalLayoutBy = By.xpath("//div[normalize-space()='Traditional']");
}
