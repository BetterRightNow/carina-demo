package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(id = "login-active")
    private ExtendedWebElement loginIcon;

    @FindBy(id = "login-popup2")
    private LoginPanel loginPanel;

    @FindBy(xpath = "//span[@class='icon-count' and contains(text(), 'PavelDem')]")
    private ExtendedWebElement accountHint;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public LoginPanel openLoginPanel() {
        loginIcon.click();
        return loginPanel;
    }

    public boolean userLoggedIn () {
        return accountHint.isElementPresent();
    }

}
