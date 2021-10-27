import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.SetValue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class Test1 {
    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https:https://ee.ge/");
        $(byText("რეგისტრაცია")).click();
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.appear);
        $(byName("firstname")).setValue("Ani");
        $(byName("firstname")).shouldNotBe(Condition.empty);
        $(byName("lastname")).setValue("Tsamalashvili");
        $(byName("lastname")).shouldNotBe(Condition.empty);
        sleep(4000);
    }


     @Test
    public void Facebook(){
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open( "https://www.facebook.com/");
        $(byLinkText("Create New Account")).click();
        sleep(2000);
        $(byName("firstname")).setValue("Ani");
        $(byName("lastname")).setValue("Tsamalashvili");
        $(byName("reg_email__")).setValue("599855105");
        $(byName("reg_passwd__")).setValue("Jbcfejbek123");
        $(byName("birthday_year")).selectOption("1996");
        $(byName("birthday_day")).selectOption("13");
        $(byName("birthday_month")).selectOption("Jun");
        $(byText("Custom")).click();
        sleep(1000);
        $(byName("custom_gender")).shouldBe(Condition.visible);
        $(byName("preferred_pronoun")).shouldBe(Condition.visible);
        sleep(2000);
        $(byText("Female")).click();
        $(byName("preferred_pronoun")).shouldBe(Condition.hidden);
        $(byName("custom_gender")).shouldBe(Condition.hidden);







    }





}
