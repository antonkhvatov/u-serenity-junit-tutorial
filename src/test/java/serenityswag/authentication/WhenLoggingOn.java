    package serenityswag.authentication;

    //import net.thucydides.core.annotations.Managed;
    import net.serenitybdd.annotations.Managed;
    import net.serenitybdd.annotations.Steps;
    import net.serenitybdd.core.Serenity;
    import net.serenitybdd.core.steps.UIInteractionSteps;
    import net.serenitybdd.junit5.SerenityJUnit5Extension;
   // import net.thucydides.core.annotations.Managed;  //@Managed import
   // import org.junit.Test;

    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
 //   import org.junit.runner.RunWith;
  //  import net.serenitybdd.junit.runners.SerenityRunner; //WebDriver import
   // import org.openqa.selenium.By;

    import org.openqa.selenium.WebDriver;
    import serenityswag.authentication.actions.LoginActions;
    import serenityswag.inventory.InventoryPage;

    import static org.assertj.core.api.Assertions.assertThat;
    import static serenityswag.authentication.User.STANDARD_USER;


    //    @RunWith(SerenityRunner.class)
    @ExtendWith(SerenityJUnit5Extension.class)
//    The @ExtendWith annotation tells JUnit that this test uses Serenity - don't forget this annotation or your test won't be recognised as a Serenity test
    public class WhenLoggingOn {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\triba\\Downloads\\chromedriver-win64\\chromedriver.exe");
//        @Managed

//        @Managed(driver = "chrome", options = "headless")
        @Managed(driver = "chrome")
        WebDriver driver;

        @Steps
        LoginActions login;

        InventoryPage inventoryPage;

//        The @Test annotation uses the org.junit.jupiter.api.Test class, from JUnit 5. Be careful not to get this mixed up with the JUnit 4 annotation of the same name (org.junit.Test), otherwise your test won't run.
        @Test
        public void usersCanLogOnViaTheHomePage() {
//            login.usingCredentials("standard_user","secret_sauce");
            login.as(STANDARD_USER);
//            assertThat(driver.findElement(By.cssSelector(".title")).getText())
//                    .isEqualToIgnoringCase("Products");
            Serenity.reportThat("The inventory page should be displayed with the correct title",
                    () -> assertThat(inventoryPage.getHeading())
                            .isEqualToIgnoringCase("Products")
            );

        }
        @Test
        public void usersCanLogOnViaTheHomePage2() {

            login.as(User.ERROR_USER);
        }

        @Test
        public void usersCanLogOnViaTheHomePage3() {

            login.as(User.PERFORMANCE_GLITCH_USER);
        }



    }
