package com.zebrunner.carina.demo.gui.components;

import com.zebrunner.carina.demo.gui.pages.desktop.EvPage;
import com.zebrunner.carina.demo.gui.pages.desktop.MerchPage;
import com.zebrunner.carina.demo.gui.pages.desktop.RegisterPage;
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

    @FindBy(xpath = "//i[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//i[@class='head-icon icon-cart icomoon-liga']")
    private ExtendedWebElement merchButton;

    @FindBy(xpath = "//i[@class='head-icon icon-specs-car icomoon-liga']")
    private ExtendedWebElement evButton;

    @FindBy(xpath = "//i[@class='head-icon icon-soc-rss2 icomoon-liga']")
    private ExtendedWebElement rssButton;

    @FindBy(xpath = "//i[@class='head-icon icon-instagram icomoon-liga']")
    private ExtendedWebElement instagramButton;

    @FindBy(xpath = "//i[@class='head-icon icon-soc-youtube icomoon-liga']")
    private ExtendedWebElement youTubeButton;

    @FindBy(xpath = "//i[@class='head-icon icon-tip-us icomoon-liga']")
    private ExtendedWebElement tipUsButton;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public LoginPanel openLoginPanel() {
        loginIcon.click();
        return loginPanel;
    }

    public ExtendedWebElement getLoginIcon() {
        return loginIcon;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public ExtendedWebElement getSignUpButton() {
        return signUpButton;
    }

    public ExtendedWebElement getMerchButton() {
        return merchButton;
    }

    public ExtendedWebElement getEvButton() {
        return evButton;
    }

    public ExtendedWebElement getRssButton() {
        return rssButton;
    }

    public ExtendedWebElement getInstagramButton() {
        return instagramButton;
    }

    public ExtendedWebElement getYouTubeButton() {
        return youTubeButton;
    }

    public ExtendedWebElement getTipUsButton() {
        return tipUsButton;
    }

    public boolean userLoggedIn () {
        return accountHint.isElementPresent();
    }

    public RegisterPage openRegisterPage() {
        signUpButton.click();
        return new RegisterPage(driver);
    }

    public MerchPage openMerchPage() {
        merchButton.click();
        return new MerchPage(driver);
    }

    public EvPage openEvPage() {
        evButton.click();
        return new EvPage(driver);
    }
}
