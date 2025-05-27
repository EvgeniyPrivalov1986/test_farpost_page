package tests.loggingtest;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.LOGIN_PAGE;
import static constants.Constant.Urls.PERSONAL_PAGE;
import static constants.Constant.UsersData.INVALID_USER_LOGIN;
import static constants.Constant.UsersData.INVALID_USER_PASSWORD;
import static constants.Constant.UsersData.VALID_USER_LOGIN;
import static constants.Constant.UsersData.VALID_USER_PASSWORD;
import static constants.Constant.Errors.VALIDATION_ERROR;

public class LoggingTest extends BaseTest {

    @Test
    public void loginTest() {
        // Открываем страницу логина
        basePage.open(LOGIN_PAGE);

        // Выполняем логин с невалидными данными пользователя
        loginPage.loggingIn(INVALID_USER_LOGIN, INVALID_USER_PASSWORD);

        // Проверяем, что URL не изменился
        basePage.checkUrl(LOGIN_PAGE);

        // Проверяем, что появилась ошибка валидации
        loginPage.checkValidation(VALIDATION_ERROR);

        // Выполняем логин с валидными данными пользователя
        loginPage.loggingIn(VALID_USER_LOGIN, VALID_USER_PASSWORD);

        // Проверяем, что перешли в профиль пользователя
        basePage.checkUrl(PERSONAL_PAGE);

    }
}