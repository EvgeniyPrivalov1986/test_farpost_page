package tests.searchtest;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.MAIN_PAGE;
import static constants.Constant.Urls.AFTER_SEARCH_PAGE;
import static constants.Constant.Urls.AFTER_FILTRATION_PAGE;
import static constants.Constant.TestsData.SEARCH_VALUE;
import static constants.Constant.TestsData.COUNT_ELEMENTS_SEARCH_HOLDER;
import static constants.Constant.TestsData.MAX_PRICE;

public class SearchTest extends BaseTest {

    @Test
    public void loginTest() {
        // Открываем главную страницу
        basePage.open(MAIN_PAGE);

        // Проверяем, что открылась нужная страница
        basePage.checkUrl(MAIN_PAGE);

        // Выполняем поиск
        mainPage.search(SEARCH_VALUE);

        // Проверяем url после выполнения поиска
        basePage.checkUrl(AFTER_SEARCH_PAGE);

        // Проверяем что держатель поиска виден
        mainPage.сheckSearchHolderVisible();

        // Проверяем количество элементов держателя поиска
        mainPage.сheckSearchHolderCount(COUNT_ELEMENTS_SEARCH_HOLDER);

        // Проверяем что первый элемент держателя поиска выбран
        mainPage.сheckSearchHolderItemActive(0);

        // Выполняем фильтрацию по максимальной цене
        mainPage.setFilterByMaxPrice(MAX_PRICE);

        // Проверяем url после фильтрации
        basePage.checkUrl(AFTER_FILTRATION_PAGE);

        // Проверяем что держатель поиска скрыт
        mainPage.сheckSearchHolderHidden();

        // Проверяем url после фильтрации
        mainPage.checkPricesNotExceedValue(MAX_PRICE);
    }
}