import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Указываем путь к chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");

        // Запускаем браузер
        WebDriver driver = new ChromeDriver();

        // Открываем страницу
        driver.get("https://www.google.com");

        // Закрываем браузер
        driver.quit();
    }
}