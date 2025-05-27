package tests.base;

import basic.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;
import pages.base.BasePage;
import pages.loginpage.LoginPage;
import pages.mainpage.MainPage;

import static basic.Config.CLEAR_COOKIES_AND_STORAGE;
import static basic.Config.HOLD_BROWSER_OPEN;

// Базовый класс тестов
public class BaseTest {

    protected WebDriver driver = BasicActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected MainPage mainPage = new MainPage(driver);

    // После каждого теста — очистка cookies и sessionStorage
    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            js.executeScript("window.sessionStorage.clear()");
        }
    }

    // После всех тестов — закрытие браузера
    @AfterSuite
    public void clear() {
        if (!HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}