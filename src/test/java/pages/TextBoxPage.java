package pages;

import com.codeborne.selenide.SelenideElement;
import pages.componets.TableResults;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit");

    private final TableResults checkResults = new TableResults();
    private final TableResults unsuccessfulRegistration = new TableResults();

    public TextBoxPage openPage(){
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }
    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddressInput(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage checkBoxResults(String key, String value) {
        checkResults.checkBoxResults(key, value);
        return this;
    }

    public void clickSubmit() {
        submitInput.click();
    }
}
