package com.zebrunner.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import com.zebrunner.carina.demo.gui.components.HeaderMenu;
import com.zebrunner.carina.demo.gui.components.LoginPanel;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "Pavel D")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.refresh();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginPanel loginPanel = headerMenu.openLoginPanel();
        loginPanel.loginYourAccount();
        pause(5000);
        Assert.assertTrue(headerMenu.userLoggedIn(), "user haven't logged in");
    }

    @Test()
    @MethodOwner(owner = "Pavel D")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testFirefox() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
    }
}
