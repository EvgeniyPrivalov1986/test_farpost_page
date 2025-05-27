package pages.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

// Страница логина
public class LoginPage extends BasePage {

    // Конструктор
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Локаторы
    private final By loginInput = By.xpath("//input[@name='sign']");
    private final By passwordInput = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By validationError = By.xpath("//div[@class='passwordRecoveryView']");


    // Метод для авторизации: ввод логина и пароля + клик по кнопке
    public LoginPage loggingIn(String login, String password) {
        driver.findElement(loginInput).clear();
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return this;
    }

    // Метод для проверки ошибки валидации
    public LoginPage checkValidation(String error_text) {
        waitTextInElement(driver.findElement(validationError), error_text);
        return this;
    }
}