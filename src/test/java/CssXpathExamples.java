import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpath() {
        // <input type="email" class ="inputtext login_form_input_box" name="email" id="email" data-testing="email">
        $("[data-testid=email]").setValue("1"); //самый оптимальный вариант по какому атрибуту искать
        $(by("data-testid", "email")).setValue("1"); //как вариант. Поиск по названию и значению атрибута
        $x("//*[@data-testid='email']").setValue("1");

        // <input type="email" class ="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("1");
        $(by("id", "email")).setValue("1");
        $(byId("email")).setValue("1");//в селениде есть спец. функция поиска по ID
        $("#email").setValue("1"); //топ вариант
        $x("//*[@id='email']").setValue("1");

        // <input type="email" class ="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("1");
        $(by("name", "email")).setValue("1");
        $(byName("email")).setValue("1");
        $x("//*[@name='email']").setValue("1");

        // <input type="email" class ="inputtext login_form_input_box">
        $("[class=inputtext] [class=login_form_input_box]").setValue("1");
        $(".login_form_input_box").setValue("1"); //топовый и надёжный вариант в данном случае
        $(".inputtext.login_form_input_box").setValue("1");
        $("input.login_form_input_box").setValue("1"); //ищем по типу и классу
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1");

        //<div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        //</div>
        $(".inputtext .login_form_input_box").setValue("1");//пробел, т.к. два разных класса у разных элементов
        $(".inputtext").$(".login_form_input_box").setValue("1"); //аналог поиска локатора, что выше
        $("div.inputtext").$("input.login_form_input_box").setValue("1");//еще аналог уже с типами элементов
        $("div.inputtext input.login_form_input_box").setValue("1"); //упрощение строки, что выше (уже с пробелом, вместо знака $)

        //<div>Hello, qa.guru!</div>
        $(byText("Hello, qa.guru!")); //по всему тексту
        $(withText("llo, qa.g")); //поиск по части текста
        $x("//*[text()='Hello, qa.guru!']"); //считается, что вариант не очень хороший
        $x("//*[contains(text(),'Hello, qa.guru!')]"); //т.е. поиску по содержанию текста (contains это означает содержит)
        $x(".='Hello, qa.guru!'");

    }
}
