package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.CommonPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonPage {

    @FindBy(id = "uname")
    private ExtendedWebElement loginInput;

    @FindBy(id = "upass")
    private ExtendedWebElement passInput;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement submitButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.gsmarena.com/register.php3");
    }

    public boolean registerElementsPresent() {
        return loginInput.isPresent() && passInput.isPresent() && submitButton.isPresent();
    }

    public ExtendedWebElement getLoginInput() {
        return loginInput;
    }

    public ExtendedWebElement getPassInput() {
        return passInput;
    }

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }
}
