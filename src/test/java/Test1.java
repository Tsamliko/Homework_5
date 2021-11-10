import FinalProject.Chrome.ChromeRunner;
import FinalProject.Chrome.Retry;
import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Listeners (FinalProject.Chrome.TestLister.class)
public class Test1 extends ChromeRunner {
    @Test(retryAnalyzer = Retry.class)
    public void test() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
       $(byText("რეგისტრაცია")).click();
       Assert.assertFalse($(byText("სწრაფი რეგისტრაცია")).is(Condition.visible));
       $(byId("firstName")).setValue("ani");
       Assert.assertTrue($(byId("firstName")).is(Condition.empty));
       $(byId("lastName")).setValue("test");
       Assert.assertFalse($(byId("lastName")).is(Condition.empty));
       $(byName("email")).setValue("tsamliko123@gmail.com");
       $(by("id","Password")).setValue("test");
       $(by("id","ConfirmPassword")).setValue("test");
       sleep(4000);
    }


    @Test
    public void Neg1() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;

        $(byText("რეგისტრაცია")).click();
        $("#signup").shouldBe(Condition.disabled);
        $(byId("firstName")).click();
        $(byId("lastName")).click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        $(byId("lastName")).click();
        $(byId("email")).click();
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        $(byId("email")).click();
        $(byId("password")).click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $(byId("password")).click();
        $(byId("confirmPassword")).click();
        Assert.assertTrue($(byText("პაროლი სავალდებულოა")).is(Condition.appear));
        $(byId("confirmPassword")).sendKeys(Keys.BACK_SPACE);
    }


    @Test
    public void neg2() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        $(".btn-cart").click();
        $(".btn-cart").shouldBe(Condition.empty);
        $(byId("search-list")).setValue("კომპიუტერი").pressEnter();
        $(byClassName("d-xs-none")).click();




    }

}
