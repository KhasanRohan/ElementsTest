package elements;

import com.codeborne.selenide.CollectionCondition;
import core.BaseTest;
import elements.page.CheckBoxPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class CheckBoxTest extends BaseTest {



    @Test
    void checkingAll() {
        step("Открыть URL", () -> {
            open("/checkbox");
        });
        $(".main-header").shouldHave(text("Check box"));
        $(".rct-text").shouldHave(text("Home"));
        $("#tree-node > ol > li > span > button > svg").click();// home
        $$("li").filterBy(text("Desktop")).shouldHave(size(2));
        $(".rct-icon-uncheck").shouldNotBe(checked);
        $(".rct-checkbox").click();
        $("#tree-node > ol > li > ol > li:nth-child(1) > span > button").click();// desktop
//        $$("ol li").filterBy(text("Notes")).shouldHave(size(1)); todo проверку на кол во элементов в списке
        $("#tree-node > ol > li > ol > li:nth-child(2) > span > button").click();// documents
        $("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > span > button").click();// workspace
        $("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > span > button").click();// office
        $("#tree-node > ol > li > ol > li.rct-node.rct-node-parent.rct-node-collapsed > span > button").click();// download
        $("#result").shouldBe(appear);
        $("#result").$$("span").shouldHave(
                texts("You have selected :",
                        "home",
                        "desktop",
                        "notes",
                        "commands",
                        "documents",
                        "workspace",
                        "react",
                        "angular",
                        "veu",
                        "office",
                        "public",
                        "private",
                        "classified",
                        "general",
                        "downloads",
                        "wordFile",
                        "excelFile"));

//        $(".rct-icon-check").shouldBe(checked);

//        sleep(5000);
    }
    public static final String TITLE = "Check box";

    @Tag("check")
    @Test
    void checkOptions() {
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        step("Открыть URL", () -> {
            checkBoxPage.openPage();
        });
        step("Проверить текст заголовка " + TITLE, () -> {
            checkBoxPage.checkHeader("Check box");
        });

        $(".rct-option-expand-all").click();
        $(".rct-node-expanded").shouldBe(appear);
        $(".rct-option-collapse-all").click();
        $(".rct-node-collapsed").shouldBe(disappear);
    }
}
