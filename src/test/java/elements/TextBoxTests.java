package elements;

import core.BaseTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;



public class TextBoxTests extends BaseTest {
    String userName = "Khasan",
            mail = "khasan@mail.ru",
            address = "Republic of Dagestan",
            permAdress = "Moscow City";
    @Tags({@Tag("BLOCKER"), @Tag("UI-TEST")})
    @Test
    void textBox(){
         textBoxPage.openPage()
                 .setFullName(userName)
                 .setEmail(mail)
                 .setCurrentAddress(address)
                 .setPermanentAddress(permAdress)
                 .clickButton();// todo сделать проверку на видимость окна и проверок ключ значение
        textBoxPage.modalResult();
        textBoxPage.verifyResult("Name;", userName)
                    .verifyResult("Email:", mail)
                    .verifyResult("Current Address :", address)
                    .verifyResult("Permananet Address :", permAdress);



    }

    @Test
    void name() {
        //fdfg

    }
}
