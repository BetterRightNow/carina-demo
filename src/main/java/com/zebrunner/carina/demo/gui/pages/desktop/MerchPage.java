package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.pages.common.CommonPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MerchPage extends CommonPage {

    @FindBy(xpath = "//a[@class='header__link' and @href='/']")
    private ExtendedWebElement homeButton;

    @FindBy(xpath = "//a[@class='header__link' and @href='/collections/all']")
    private ExtendedWebElement browseAllButton;

    @FindBy(xpath = "//a[@class='header__icon header__icon--cart']")
    private ExtendedWebElement cartButton;

    public MerchPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://merch.gsmarena.com/");
    }

//    public boolean merchElementsPresent() {
//        return homeButton.isPresent() && browseAllButton.isPresent() && cartButton.isPresent();
//    }

    public ExtendedWebElement getHomeButton() {
        return homeButton;
    }

    public ExtendedWebElement getBrowseAllButton() {
        return browseAllButton;
    }

    public ExtendedWebElement getCartButton() {
        return cartButton;
    }
}
