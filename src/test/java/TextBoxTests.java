import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $x("//*[@id='userName']").setValue("Anna");
        $x("//*[@id='userEmail']").setValue("Anna@testova.ru");
        $x("//*[@id='currentAddress']").setValue("street of Roses 51");
        $x("//*[@id='permanentAddress']").setValue("street of Soviet 29");
        $x("//*[@id='submit']").click();

        $x("//*[@id='output']//*[@id='name']").shouldHave(text("Anna"));
        $x("//*[@id='output']//*[@id='email']").shouldHave(text("Anna@testova.ru"));
        $x("//*[@id='output']//*[@id='currentAddress']").shouldHave(text("street of Roses 51"));
        $x("//*[@id='output']//*[@id='permanentAddress']").shouldHave(text("street of Soviet 29"));
    }
}
