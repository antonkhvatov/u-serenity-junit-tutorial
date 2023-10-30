package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPageObject extends PageObject {
    public List<String> titles() {
       // List<WebElement> titleElements  = findAll(By.className("inventory_item_name"));
        //return findAll(By.className("inventory_item_name")).textContents();
        return findAll(".inventory_item_name").textContents();
    }

    public void openProductDetailsFor(String itemName) {
        find(By.linkText(itemName)).click();
    }

    public String imageTextForProduct(String productName) {
        //return find(By.xpath(("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img"))).getAttribute("alt");
        return $("xpath://div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }
}
