package com.zebrunner.carina.demo.gui.pages.desktop;

import com.zebrunner.carina.demo.gui.components.HeaderMenu;
import com.zebrunner.carina.demo.gui.pages.common.CommonPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EvPage extends CommonPage {

    @FindBy(id = "header")
    private ExtendedWebElement evHeader;
    @FindBy(id = "footer")
    private ExtendedWebElement evFooter;

    @FindBy(xpath = "//p[text()='Consent']")
    private ExtendedWebElement consentButton;

    public EvPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.arenaev.com/");
    }
    public boolean evElementsPresent() {
        return evHeader.isPresent() && evFooter.isPresent();
    }

    public ExtendedWebElement getEvHeader() {
        return evHeader;
    }

    public ExtendedWebElement getEvFooter() {
        return evFooter;
    }
    public void consentCookies() {
        consentButton.click();
    }
}
