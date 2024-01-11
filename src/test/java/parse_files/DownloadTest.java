package parse_files;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DownloadTest extends BaseTest {

    @Test
    void loadImage() throws Exception {
        open("/upload-download");
        File downloadFile = $("#downloadButton").download();
    }

    @Test
    void uploadImage() {
        open("/upload-download");
        $("input[type='file']").uploadFromClasspath("files/sampleFile.jpeg");
        $("#uploadedFilePath").shouldHave(text("C:\\fakepath\\sampleFile.jpeg"));

    }
}
