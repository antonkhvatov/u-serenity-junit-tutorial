package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;

public class InventoryPage extends PageObject {
    public String getHeading() {
        return $(".title").getText();
        //$$(".inventory_item_name") collection of elements by class in webtools


    }
}
