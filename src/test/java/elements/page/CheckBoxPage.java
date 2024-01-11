package elements.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckBoxPage {
    private final SelenideElement title = $(".main-header");

    public void openPage(){
        open("/checkbox");
    }
    public void checkHeader(String value){
        title.shouldHave(text(value));
    }
}
