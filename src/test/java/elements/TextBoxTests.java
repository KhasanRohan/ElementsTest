package elements;

import core.BaseTest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;



public class TextBoxTests extends BaseTest {


    @Tags({@Tag("BLOCKER"), @Tag("UI-TEST")})
    @Test
    void textBox(){
         textBoxPage.openPage()
                 .setFullName(data.userFullName)
                 .setEmail(data.mail)
                 .setCurrentAddress(data.address)
                 .setPermanentAddress(data.permAddress)
                 .clickButton();// todo сделать проверку на видимость окна и проверок ключ значение
        textBoxPage.modalResult();
        textBoxPage.checkResult("Name:"+data.userFullName, "Email:"+data.mail,
                "Current Address :"+data.address,
                "Permananet Address :"+data.permAddress);

    }

    @Test
    void name() {
      // negative

    }
}
