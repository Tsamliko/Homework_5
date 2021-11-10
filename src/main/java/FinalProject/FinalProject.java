package FinalProject;

import FinalProject.Chrome.ChromeRunner;
import FinalProject.Chrome.Retry;
import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

//@Listeners (FinalProject.Chrome.TestLister.class)
public class FinalProject extends ChromeRunner {
    @Test(retryAnalyzer = Retry.class)
    public void FinalProject() {
        WebDriverManager.firefoxdriver().setup();
        Configuration.startMaximized = true;
        Selenide.open("https://www.amazon.com");
//        $(byId("nav-link-accountList-nav-line-1")).click();
//        sleep(1000);
//        $(byId("createAccountSubmit")).click();
//        $(byId("ap_customer_name")).setValue("Ani");
//        $(byId("ap_email")).setValue("anitsamalashvili13@gmail.com");
//        $(byId("ap_password")).setValue("test");
//        $(byId("ap_password_check")).setValue("test");;
//        $(byId("continue")).waitUntil(Condition.visible,| 1500);
        $(byName("field-keywords")).setValue("playstation gift card").pressEnter();
        $(byLinkText("$25 PlayStation Store Gift Card [Digital Code]")).click();
        $(byName("submit.add-to-cart")).click();
        sleep(1000);
        $(byId("nav-cart-text-container")).click();
        Assert.assertTrue($(byId("nav-cart-text-container")).is(Condition.visible));
        $(byValue("Delete")).click();









    }


    }

