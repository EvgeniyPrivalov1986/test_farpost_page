Introduction
------------

Этот репозиторий содержит решение тестового задания по автоматизации тестирования страниц https://www.farpost.ru/sign и https://www.farpost.ru/vladivostok/, с использованием паттерна PajeObjects.

Stack
------------

 - Java
 - Selenium Webdriver
 - maven-surefire-plugin
 - allure-maven

Test-cases
------------

Test-case #1:
1. Открыть https://www.farpost.ru/sign
2. Перейти по ссылке "Вход и регистрация"
3. Попытаться войти с неправильными логином и паролем. Убедиться, что
произошла ошибка и войти не удалось
4. Войти, используя правильный логин и пароль. Убедиться, что вход успешен,
открыт личный кабинет
5. Логин и пароль можно задавать через параметры любым способом


Test-case #2:
1. Открыть https://www.farpost.ru/vladivostok/
2. В строке поиска вбить "iphone" и нажать кнопку "Найти"
3. Убедиться, что открыта страница с адресом
https://www.farpost.ru/vladivostok/tech/communication/cellphones/+/Apple+iPhone/?
_suggest=1&query=iphone
4. Убедиться, что на странице есть блок
5. Убедиться, что в блоке три элемента и первый из них активен
6. Выбрать фильтр цена и отфильтровать предложения по максимальной цене в
1000 р.
7. Убедиться, что адрес начинается с
https://www.farpost.ru/vladivostok/tech/communication/cellphones/+/Apple+iPhone/?
price_max=1000&query=iphone
8. Убедиться, что блока из пункта 4 нет
9. Убедиться, что на странице нет предложений дороже 1000 р.

Files
-----

[BasicActions](test_farpost/src/main/java/basic/BasicActions.java) Содержит настройки для запуска браузера

[Config](test_farpost/src/main/java/basic/Config.java) Содержит общие параметры запуска

[Constant](test_farpost/src/main/java/constants/Constant.java) Содержит тестовые данные

[BasePage](test_farpost/src/main/java/pages/base/BasePage.java) Содержит базовый класс для описания страниц

[LoginPage](test_farpost/src/main/java/pages/loginpage/LoginPage.java) Содержит класс для описания страницы https://www.farpost.ru/sign

[MainPage](test_farpost/src/main/java/pages/mainpage/MainPage.java) Содержит базовый класс для описания страницы https://www.farpost.ru/vladivostok/

[BaseTest](test_farpost/src/test/java/tests/base/BaseTest.java) Содержит базовый класс, который запускает браузер, создает страницы и закрывает всё после завершения тестов

[LoggingTest](test_farpost/src/test/java/tests/loggingtest/LoggingTest.java) Содержит класс, который реализует автоматизацию Test-case №1

[SearchTest](test_farpost/src/test/java/tests/searchtest/SearchTest.java) Содержит класс, который реализует автоматизацию Test-case №2



How To Run Tests
----------------

1) Скачать репозиторий:

     ```
     https://github.com/EvgeniyPrivalov1986/tests_yandex_page.git
    ```
    
2) Скачать [Selenium WebDriver](https://developer.chrome.com/docs/chromedriver/downloads?hl=ru) Выбрать версию, совпадающую с версией браузера

3) Прописать пусть к файлу драйвера в файле [BasicActions](test_farpost/src/main/java/basic/BasicActions.java).

5) Запускать тесты можно несколькими способами:
   
   5.1 Из файла [testng.xml](test_farpost/src/test/resources/testng.xml) можно запустить оба теста

   5.2 Из файлов [LoggingTest](test_farpost/src/test/java/tests/loggingtest/LoggingTest.java) и [SearchTest](test_farpost/src/test/java/tests/searchtest/SearchTest.java) можно запустить тесты по-отдельности
   
   5.3 Если установлен Maven тесты можно запускать из консоли:
   ```
     mvn -Dtest=LoggingTest test
    ```
   ```
     mvn -Dtest=SearchTest test
    ```
