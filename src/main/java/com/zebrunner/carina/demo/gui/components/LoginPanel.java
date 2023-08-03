package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPanel extends AbstractUIObject {
    @FindBy(id = "email")
    private ExtendedWebElement emailInput;
    @FindBy(id = "upass")
    private ExtendedWebElement passwordInput;
    @FindBy(id = "nick-submit")
    private ExtendedWebElement loginButton;


    public LoginPanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void printEmail (){
        emailInput.type("icy4ok@gmail.com");
    }
    public void printPassword (){
        passwordInput.type("123123");
    }
    public void loginYourAccount () {
        this.printEmail();
        this.printPassword();
        loginButton.click();
    }
//    public boolean allElementsPresent() {
//        return emailInput.isPresent() && passwordInput.isPresent() && loginButton.isPresent();
//    }

    public ExtendedWebElement getEmailInput() {
        return emailInput;
    }

    public ExtendedWebElement getPasswordInput() {
        return passwordInput;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }
}
