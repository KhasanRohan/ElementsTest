package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import elements.TestData;
import elements.page.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.executeJavaScript;

abstract public class BaseTest {
    public TextBoxPage textBoxPage = new TextBoxPage();
    public TestData data = new TestData();

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl ="https://demoqa.com";


    }
}
