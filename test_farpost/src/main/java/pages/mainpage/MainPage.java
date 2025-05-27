package pages.mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;


// Страница логина
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    // Локаторы
    private final By SearchInput = By.xpath("//input[@id='search']");
    private final By SearchButton = By.xpath("//input[@type='submit']");
    private final By SearchHolder = By.xpath("//div[@class='suggestionsList dir-search-suggest']");
    private final By SearchHolderItem = By.className("dir-search-suggest__item");
    private final By FilterPrice = By.xpath("//a[@data-url-label='cena']");
    private final By MaxPriceInput = By.xpath("//input[@id='price_max']");
    private final By BlockPrice = By.xpath("//div[@class='price-block__price']");

    // Метод для поиска: ввод значения + клик по кнопке поиск
    public MainPage search(String value) {
        driver.findElement(SearchInput).clear();
        driver.findElement(SearchInput).sendKeys(value);
        driver.findElement(SearchButton).click();
        driver.findElement(SearchHolder);
        return this;
    }

    // Метод для проверки, что держатель поиска виден
    public MainPage сheckSearchHolderVisible() {
        waitElementIsVisible(driver.findElement(SearchHolder));
        return this;
    }

    // Метод для проверки, что держатель поиска скрыт
    public MainPage сheckSearchHolderHidden() {
        waitElementIsNotVisible(driver.findElement(SearchHolder));
        return this;
    }

    // Метод для проверки количества элементов держателя поиска
    public MainPage сheckSearchHolderCount(int count) {
        int ItemCount = driver.findElements(SearchHolderItem).size();
        Assert.assertEquals(ItemCount, count, "Количество элементов держателя поиска не совпадает");
        return this;
    }

    // Метод для проверки активного элемента держателя поиска
    public MainPage сheckSearchHolderItemActive(int count) {
        waitElementGetAttribute(
                driver.findElements(SearchHolderItem).get(count), "class", "dir-search-suggest__item_active");
        return this;
    }

    // Метод для фильтрации по максимальной цене: выбираем фильтр цена, вводим максимальное значение + клик по поиску
    public MainPage setFilterByMaxPrice(int max_price) {
        driver.findElement(FilterPrice).click();
        driver.findElement(MaxPriceInput).clear();
        driver.findElement(MaxPriceInput).sendKeys(String.valueOf(max_price));
        driver.findElement(SearchButton).click();
        return this;
    }

    // Метод для проверки, что цена в блоках не превышает заданную
    public MainPage checkPricesNotExceedValue(int max_price) {
        int ItemCount = driver.findElements(BlockPrice).size();
        for (int item=0; item<ItemCount; item++) {
            String priceItem =  driver.findElements(BlockPrice).get(item).getText()
                    .replace("₽", "").replace(" ", "");
            Assert.assertTrue(
                    Integer.parseInt(priceItem) <= max_price, "Цена в блоке не соответствует фильтрации");
        }
        return this;
    }
}