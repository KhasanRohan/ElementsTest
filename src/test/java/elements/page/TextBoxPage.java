package elements.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final static String TITLE_TEXT = "Text Box";
    private final SelenideElement
            userFullNameInput = $x("//input[@id='userName']"),
            userInputEmail = $x("//input[@id='userEmail']"),
            currentAddressInput = $x("//textarea[@id='currentAddress']"),
            permanentAddressInput = $x("//textarea[@id='permanentAddress']"),
            header = $(".main-header"),
            submitButton = $x("//button[@id='submit']"),
            result = $("#output #name"),
            nameResult = $("#name"),
            emailResult = $("#email"),
            currentAddressResult = $("#currentAddress"),
            permanentAddressResult = $("#permanentAddress");




    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('footer').remove()");
        header.shouldHave(text(TITLE_TEXT));
        return this;
    }

    public TextBoxPage setFullName(String value) {
        userFullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userInputEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public void clickButton() {
        submitButton.click();
    }
    public void modalResult() {
        result.shouldBe(visible);
    }

    public TextBoxPage verifyResult(String key, String value) {
        result.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    public void checkResult(String name, String email, String currentAddress, String permanentAddress) {
        nameResult.shouldHave(text(name));
        emailResult.shouldHave(text(email));
        currentAddressResult.shouldHave(text(currentAddress));
        permanentAddressResult.shouldHave(text(permanentAddress));
    }

}