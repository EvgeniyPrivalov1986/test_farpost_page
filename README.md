Introduction
------------

Этот репозиторий содержит решение тестового задания по автоматизации тестирования страниц:
- https://www.farpost.ru/sign
- https://www.farpost.ru/vladivostok

## Stack

 - Java
 - Selenium Webdriver
 - TestNG
 - maven-surefire-plugin
 - allure-maven

Test-cases
------------

Test-case #1:
1. Открыть https://www.farpost.ru/
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

[BaseTest](test_farpost_page/src/test/java/tests/base/BaseTest.java) Содержит базовый класс, который запускает браузер, создает страницы и закрывает всё после завершения тестов
[LoggingTest](test_farpost_page/src/test/java/tests/base/LoggingTest.java) Содержит класс, который реализует автоматизацию Test-case №1
[SearchTest](test_farpost_page/src/test/java/tests/base/SearchTest.java) Содержит класс, который реализует автоматизацию Test-case №2

How To Run Tests
----------------

1) Клонировать репозиторий:

    ```bash
    git clone [https://github.com/EvgeniyPrivalov1986/test_farpost_page.git](https://github.com/EvgeniyPrivalov1986/test_farpost_page.git)
    ```
    
2) Скачать Selenium WebDriver (https://developer.chrome.com/docs/chromedriver/downloads?hl=ru)
   Выбрать версию, совпадающую с версией браузера

3) Прописать пусть к файлу драйвера в файле [src/main/java/Main.java](src/main/java/Main.java):

5) Запускать тесты можно несколькими способами:
  5.1 Из файла [src/test/resources/testng.xml](test_farpost_page/src/test/resources/testng.xml) можно запустить оба теста последовательно
  5.2 Из файлов [LoggingTest](test_farpost_page/src/test/java/tests/loggingtest/LoggingTest.java) и [SearchTest](test_farpost_page/src/test/java/tests/searchtest/SearchTest.java) можно запустить тесты по-отдельности
