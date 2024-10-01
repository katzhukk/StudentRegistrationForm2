package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {/* Всегда пишется со static. Вызывается один перед всеми тестами в этом тестовом классе*/
        Configuration.browserSize = "1920x1080";        /* Задаем разрешение браузера */
        Configuration.baseUrl = "https://demoqa.com";   /* Открывает основную страницу сайта */
        Configuration.pageLoadStrategy = "eager";       /* Не ждем, когда загрузится полностью страница, чтобы долго не ждать*/
        //Configuration.holdBrowserOpen = true;         /* Не дает закрыть тесту браузер. Нужно только для отладки */
    }

    TextBoxPage textBoxPage = new TextBoxPage();

    String userName = "Kate Ivanova";
    String userEmail = "kate@ivanova.ru";
    String currentAddress = "Some street 1";
    String permanentAddress = "Another street 1";

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddressInput(permanentAddress)
                .clickSubmit();

        textBoxPage.checkBoxResults("Name:", userName)
                .checkBoxResults("Email:", userEmail)
                .checkBoxResults("Current Address :", currentAddress)
                .checkBoxResults("Permananet Address :", permanentAddress);
    }
}