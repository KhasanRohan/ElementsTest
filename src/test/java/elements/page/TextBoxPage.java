package elements.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final static String TITLE_TEXT = "Text Box";
    private final SelenideElement
            fullName = $x("//input[@id='userName']"),
            email = $x("//input[@id='userEmail']"),
            currentAddress = $x("//textarea[@id='currentAddress']"),
            permanentAddress = $x("//textarea[@id='permanentAddress']"),
            header = $(".main-header"),
            button = $x("//button[@id='submit']"),
            result = $("#output");




    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('footer').remove()");
        header.shouldHave(text(TITLE_TEXT));
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullName.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public void clickButton() {
        button.click();
    }
    public void modalResult() {
        result.shouldBe(visible);
    }

    public TextBoxPage verifyResult(String key, String value) {
        $(".border").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}