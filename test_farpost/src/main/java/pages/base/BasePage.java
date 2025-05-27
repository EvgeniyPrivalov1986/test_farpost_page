package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    // Сохраняем драйвер при создании страницы
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для открытия нужной страницы
    public void open(String url) {
        driver.get(url);
    }

    // Метод для проверки текущего url
    public void checkUrl(String url) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.urlContains(url));
    }

    // Метод для ожидания видимости элемента на экране
    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    // Метод для ожидания невидимости элемента на экране
    public WebElement waitElementIsNotVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    // Метод для ожидания появления заданного текста в элементе
    public WebElement waitTextInElement(WebElement element, String value) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until((ExpectedConditions.textToBePresentInElement(element, value)));
        return element;
    }

    // Метод для ожидания появления заданного аттрибута в элементе
    public WebElement waitElementGetAttribute(WebElement element, String attribute, String value) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until((ExpectedConditions.attributeContains(element, attribute, value)));
        return element;
    }
}