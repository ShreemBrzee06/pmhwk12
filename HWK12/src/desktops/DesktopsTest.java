package desktops;

import basepackage.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void openingBrowser() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[1]//a[@class='dropdown-toggle']"));
        mouseHoverToElementAndClick(By.linkText("Show AllDesktops"));

        // list of the product displayed before sort button
        List<WebElement> beforeSortFilter = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));
        List<String> beforeSortFilters = new ArrayList<>();
        for (WebElement s : beforeSortFilter) {
            System.out.println(s.getText());
        }
        // list of the product after clicked on sort button
        WebElement sort = driver.findElement(By.xpath("//select[@id='input-sort']"));
        sort.click();

        Select s = new Select(sort);
        s.selectByVisibleText("Name (Z - A)");
        List<WebElement> afterSortFilter = driver.findElements(By.xpath("//div[@class='caption']/h4/a"));
        List<String> afterSortFilters = new ArrayList<>();
        for (WebElement as : afterSortFilter) {
            System.out.println(as.getText());
        }

        Collections.sort(beforeSortFilters);
        Assert.assertNotEquals(beforeSortFilters, afterSortFilters);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[1]//a[@class='dropdown-toggle']"));
        mouseHoverToElementAndClick(By.linkText("Show AllDesktops"));
        WebElement sort = driver.findElement(By.xpath("//select[@id='input-sort']"));
        sort.click();
        Select s = new Select(sort);
        s.selectByVisibleText("Name (A - Z)");
        driver.findElement(By.linkText("HP LP3065")).click();
        System.out.println(driver.getTitle());
        clearTextFromField(By.id("input-option225"));
        driver.findElement(By.id("input-option225")).sendKeys("2022-11-30");
        clearTextFromField(By.id("input-quantity"));
        driver.findElement(By.id("input-quantity")).sendKeys("1");
        driver.findElement(By.xpath("//div[@class='form-group']//button[@id='button-cart']")).click();
        driver.findElement(By.id("cart-total")).click();

        //Click on link “shopping cart” display into success message
        String verifyingMsg = driver.findElement(By.linkText("HP LP3065")).getText();
        System.out.println(verifyingMsg);
        String ExpectedMsg = "HP LP3065";
        Assert.assertEquals("verifying desktop Msg",ExpectedMsg,verifyingMsg);

        //Verify the text "Shopping Cart"
        String actualSuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualSuccessMsg);
        String expectedSuccessMsg = "You have added HP LP3065 to your shopping cart!";
      //  Assert.assertEquals("Verify success msg:",expectedSuccessMsg,actualSuccessMsg);

       // Verify the text "Shopping Cart"
        driver.findElement(By.linkText("shopping cart")).click();
        String shoppingCartMSG = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
        System.out.println(shoppingCartMSG);
        String expectedShoppingCartMsg = "Shopping Cart  (1.00kg)";
        Assert.assertEquals("verify Shopping cart msg",expectedShoppingCartMsg,shoppingCartMSG);

        //Verify the Product name "HP LP3065"
        String productNameMsg = driver.findElement(By.linkText("HP LP3065")).getText();
        System.out.println("Product Name Msg"+""+productNameMsg);
        String expectedProductNameMsg = "HP LP3065";
        Assert.assertEquals("Verify Product Name",expectedProductNameMsg,productNameMsg);

        //Verify the Delivery Date "2022-11-30"
        String deliveryDateMsg = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody//tr[1]//td[2]//small[1]")).getText();
        System.out.println(deliveryDateMsg);
        String expectedDeliveryDateMsg ="Delivery Date:2022-11-30";
        Assert.assertEquals("Verifying DeliveryDate Msg",expectedDeliveryDateMsg,deliveryDateMsg);

        //Verify the Model "Product21"
        String ModelNameMsg = driver.findElement(By.xpath("//div[@class='table-responsive']//table//tbody//tr[1]//td[3]")).getText();
        System.out.println(ModelNameMsg);
        String expectedModelNmeMsg = "Product 21";
        Assert.assertEquals("Verifying the Product Name: ",ModelNameMsg,expectedModelNmeMsg);

        //Verify the Total "£74.73"
       String TotalAmtMsg = driver.findElement(By.xpath("//div[@class='table-responsive']//table//tbody//tr[1]//td[6]")).getText();
       System.out.println(TotalAmtMsg);
       String expectedTotalAmtMsg = "$122.00";
       Assert.assertEquals("Verifying The TotalAmtMsg",expectedTotalAmtMsg,TotalAmtMsg);

    }

    @After
    public void closingBrowser() {
          closeBrowser();
    }
}
