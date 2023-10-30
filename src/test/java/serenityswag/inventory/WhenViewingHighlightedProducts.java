package serenityswag.inventory;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
//    The @ExtendWith annotation tells JUnit that this test uses Serenity - don't forget this annotation or your test won't be recognised as a Serenity test
public class WhenViewingHighlightedProducts {

    //        @Managed(driver = "chrome", options = "headless")
    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    ProductListPageObject productList;
    ProductDetailsPageObject productDetails;
    @Test
    public void shouldDisplayHighlightedProducts(){
        login.as(User.STANDARD_USER);

        List<String> productsOnDisplay = productList.titles();
        Serenity.reportThat("The list 6 contains backpack",
                () -> assertThat(productsOnDisplay).hasSize(6)
                                     .contains("Sauce Labs Backpack")
        );

    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        login.as(User.STANDARD_USER);

        String firstItemName = productList.titles().get(0);
        productList.openProductDetailsFor(firstItemName);

        Serenity.reportThat("details page as expected",
                () -> assertThat(productDetails.productName()).isEqualTo(firstItemName)
        );
        productDetails.productImageWithAltValueOf(firstItemName).shouldBeVisible();
    }

    @Test
    public void highlightedProductsShouldDisplayTheCorrespondingImages(){
        login.as(User.STANDARD_USER);
        List<String> productsOnDisplay = productList.titles();

        SoftAssertions softly = new SoftAssertions();
        productsOnDisplay.forEach(
                productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softly.assertAll(); //if there are two images we ll report both of them
    }
}

