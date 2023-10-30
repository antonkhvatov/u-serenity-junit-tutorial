package serenityswag.authentication.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractionSteps {

    @Step("Anton log in as a {0} ")
    public void as(User user) {
        //check css selector in console
        //$("[data-test='username']")
        //$$(".title")

        //driver.get("https://www.saucedemo.com/");
        openUrl("https://www.saucedemo.com/");
//            driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
//            driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
//            driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        //here is css expressions
           // find("[data-test='username']").sendKeys(user.getUsername());
        //by ID
          //  find(By.id("user-name"));
            //css selector equwiwalent
            $("#user-name").sendKeys(user.getUsername());

           // selenium function find(By.name("password")).sendKeys(user.getPassword());
            $("[name=password]").sendKeys(user.getPassword());
         //   $("[data-test='password']").sendKeys(user.getPassword());
            $("[data-test='login-button']").click();
    }
}
