package constants;

import java.time.Duration;

public class Constant {
    // Переменные, связанные с таймингами ожидания
    public static class TimeoutVariable {
        // Время неявного ожидания (в секундах)
        public static final int IMPLICIT_WAIT = 5;
        // Время явного ожидания
        public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
    }

    // URL-адреса страниц
    public static class Urls {
        // Страница логина сайта
        public static final String LOGIN_PAGE = "https://www.farpost.ru/sign";
        // Страница профиля пользователя
        public static final String PERSONAL_PAGE = "https://www.farpost.ru/personal/";
        // Главная страница сайта
        public static final String MAIN_PAGE = "https://www.farpost.ru/vladivostok/";
        // Страница после поиска
        public static final String AFTER_SEARCH_PAGE = "https://www.farpost.ru/vladivostok/tech/communication/cellphones" +
                "/+/Apple+iPhone/?_suggest=1&query=iphone";
        // Страница после фильтрации
        public static final String AFTER_FILTRATION_PAGE = "https://www.farpost.ru/vladivostok/tech/communication/cellphones/" +
                "+/Apple+iPhone/?price_max=1000&query=iphone";
    }

    // Данные для пользователей
    public static class UsersData {
        // Логин невалидного пользователя
        public static final String INVALID_USER_LOGIN = "invalid_login";
        // Пароль невалидного пользователя
        public static final String INVALID_USER_PASSWORD = "invalid_password";
        // Логин валидного пользователя
        public static final String VALID_USER_LOGIN = "evprivalov86";
        // Пароль валидного пользователя
        public static final String VALID_USER_PASSWORD = "password_123456";
    }

    // Текст подсказки при ошибке
    public static class Errors {
        // Ошибка валидации при неверном логине
        public static final String VALIDATION_ERROR = "Пользователь не найден";
    }

    // Данные для тестов
    public static class TestsData {
        // Данные для поиска
        public static final String SEARCH_VALUE = "iphone";
        // Максимальная цена для фильтрации
        public static final int MAX_PRICE = 1000;
        // Количество элементов держателя поиска
        public static final int COUNT_ELEMENTS_SEARCH_HOLDER = 3;
    }
}