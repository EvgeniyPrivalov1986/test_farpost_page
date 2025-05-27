package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BasicActions {
    public static WebDriver createDriver() {
        // Указываем путь к ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");

        // Настраиваем запуск Chrome в режиме инкогнито
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        // Создаём драйвер с этими настройками
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Разворачиваем окно и устанавливаем неявное ожидание
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }
}