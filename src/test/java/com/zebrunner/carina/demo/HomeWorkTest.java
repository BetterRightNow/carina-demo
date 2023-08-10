package com.zebrunner.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import com.zebrunner.carina.demo.api.GetWeatherMethods;

import com.zebrunner.carina.demo.gui.components.HeaderMenu;
import com.zebrunner.carina.demo.gui.components.LoginPanel;

import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.desktop.EvPage;
import com.zebrunner.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.carina.demo.gui.pages.desktop.MerchPage;
import com.zebrunner.carina.demo.gui.pages.desktop.RegisterPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkTest implements IAbstractTest, IAbstractDataProvider {
    @Test()
    @MethodOwner(owner = "Pavel D")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.refresh(5);
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginPanel loginPanel = headerMenu.openLoginPanel();
        loginPanel.loginYourAccount();
        pause(5);
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

    @Test()
    @MethodOwner(owner = "Pavel D")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testHomePageElements() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.refresh(5);
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        Assert.assertTrue(headerMenu.isUIObjectPresent(), "Header menu didn't find");
        Assert.assertTrue(headerMenu.allElementsPresent(5,
                headerMenu.getEvButton(), headerMenu.getInstagramButton(), headerMenu.getLoginIcon(),
                headerMenu.getMerchButton(), headerMenu.getRssButton(), headerMenu.getSignUpButton(),
                headerMenu.getTipUsButton()), "Not all HeaderMenu elements found");

        LoginPanel loginPanel = headerMenu.openLoginPanel();
        Assert.assertTrue(loginPanel.isUIObjectPresent(), "Login panel didn't find");
        Assert.assertTrue(loginPanel.allElementsPresent(5,
                loginPanel.getEmailInput(), loginPanel.getPasswordInput(), loginPanel.getLoginButton()),
                "Not all elements of login panel were found");

        RegisterPage registerPage = homePage.openRegisterPage();
        Assert.assertTrue(registerPage.isPageOpened(), "Register page is not opened!");
        Assert.assertTrue(registerPage.registerElementsPresent(),
                "Not all elements of register page were found");

        String originalWindow = getDriver().getWindowHandle();
        MerchPage merchPage = headerMenu.openMerchPage();
        homePage.switchWindow();
        Assert.assertTrue(merchPage.isPageOpened(), "Merch page is not opened!");
        Assert.assertTrue(merchPage.allElementsPresent(7,
                merchPage.getBrowseAllButton(), merchPage.getHomeButton(), merchPage.getCartButton()),
                "Not all elements of merch page were found");

        getDriver().close();
        getDriver().switchTo().window(originalWindow);
        EvPage evPage = headerMenu.openEvPage();
        homePage.switchWindow();
        Assert.assertTrue(evPage.isPageOpened(), "EV page is not opened!");
        evPage.consentCookies();
        Assert.assertTrue(evPage.allElementsPresent(7, evPage.getEvFooter(), evPage.getEvHeader()), "Not all elements of merch page were found");

    }

    @Test()
    @MethodOwner(owner = "Pavel D")
    public void testGetWeather() {
        GetWeatherMethods getWeatherMethods = new GetWeatherMethods();
        getWeatherMethods.callAPIExpectSuccess();
//        getWeatherMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getWeatherMethods.validateResponseAgainstSchema("api/users/_get/weatherRs.schema");
    }

    /**
     * Parametrization using external xls/xlsx:
     * <br>
     * Every row in spreadsheet provides tests arguments set for 1 test.
     * <p>{@link XlsDataSourceParameters} annotation should contain:</p>
     *  <ul>
     *      <li>path - xls/xlsx file path located in src/test/resources
     *      <li>sheet - xls spreadsheet name
     *      <li>dsUid - column name from spreadsheet with unique identifiers
     *      <li>dsArgs - column names from spreadsheet that contains test value
     * </ul>
     *
     * @param login String
     * @param pass String
     */
    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "Pavel D")
    @XlsDataSourceParameters(path = "data_source/loginDemo.xlsx", sheet = "Calculator", dsUid = "TUID", dsArgs = "login,pass")
    public void testXlsLogin(String login, String pass) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.refresh(5);
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        LoginPanel loginPanel = headerMenu.openLoginPanel();
        loginPanel.getEmailInput().type(login);
        loginPanel.getPasswordInput().type(login);
        loginPanel.getLoginButton().click();
        Assert.assertFalse(headerMenu.userLoggedIn(), "user logged in");
    }
}