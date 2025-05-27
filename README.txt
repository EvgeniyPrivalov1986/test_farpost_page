Introduction
------------

This repository contains the solution of a test task for using
a page object template with Selenium and Python (PyTest + Selenium).

## Stack

 - Python
 - Pytest
 - Selenium
 - Pytest-html

Files
-----

[conftest.py](conftest.py) contains general fixtures, settings and plugins for tests.

[pages/base.py](pages/base.py) contains PageObject pattern implementation for Python.

[pages/page.py](pages/page.py) contains helper class to working with web elements on web pages.

[pages/locators.py](pages/locators.py) contains web elements locators.

[tests/tests_yandex_page.py](tests/test_yandex_page.py) contains searching test and images test for yandex page    (https://ya.ru/).


How To Run Tests
----------------

1) Clone the repository:

    ```bash
    git clone https://github.com/EvgeniyPrivalov1986/tests_yandex_page.git
    ```

2) Install all requirements:

    ```bash
    pip install -r requirements.txt
    ```

3) Download Selenium WebDriver from https://chromedriver.chromium.org/downloads (choose version which is compatible with your browser)

4) Run tests with saving logs in tests/pytest.log:

    ```bash
    pytest
    ```

5) Or run tests with logging and saving reports in tests/report.html:

    ```bash
    pytest --html=report.html
    ```
