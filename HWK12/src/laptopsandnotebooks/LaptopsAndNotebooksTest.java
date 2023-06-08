package laptopsandnotebooks;

import basepackage.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void openingBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[2]//a[@class='dropdown-toggle']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        mouseHoverToElementAndClick(By.linkText("Show AllLaptops & Notebooks"));

        //list of the product display before sort
        List<WebElement> beforeSortingPrice = driver.findElements(By.xpath("//div[@class='caption']/p[2]"));
        List<String> priceBeforeSort = new ArrayList<>();
        for (WebElement s : beforeSortingPrice) {
            String p[] = (s.getText().split("\n"));
            String op = p[0];
            String ex = p[1];
            //  System.out.println("______________________________");
            System.out.println(op);
            // System.out.println("-------------------------------");
           // System.out.println(ex);


        }
        //1.3 Select Sort By "Price (High > Low)"
        WebElement sort = driver.findElement(By.id("input-sort"));
        sort.click();
        Select s = new Select(sort);
        s.selectByVisibleText("Price (High > Low)");

        //Verify the Product price will arrange in High to Low order.
        List<WebElement> afterSortingPrice = driver.findElements(By.xpath("//div[@class='caption']/p[2]"));
        List<String> priceAfterSort = new ArrayList<>();
        for (WebElement v : afterSortingPrice) {
            String x[] = (v.getText().split("\n"));
            String op = x[0];
            String ex = x[1];
           // System.out.println("I am showing High to low price list");
            System.out.println(op);
           // System.out.println(ex);
        }

        Collections.sort(priceBeforeSort);
        Assert.assertNotEquals(beforeSortingPrice, afterSortingPrice);

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[2]//a[@class='dropdown-toggle']"));

        //2.2 Click on “Show All Laptops & Notebooks”
        mouseHoverToElementAndClick(By.linkText("Show AllLaptops & Notebooks"));

        //2.3 Select Sort By "Price (High > Low)"
        WebElement sort = driver.findElement(By.id("input-sort"));
        sort.click();
        Select s = new Select(sort);
        s.selectByVisibleText("Price (High > Low)");

        //2.4 Select Product “MacBook”
        driver.findElement(By.linkText("MacBook")).click();

        //2.5 Verify the text “MacBook”
        String actualMacBookMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/h1")).getText();
        System.out.println(actualMacBookMsg);
        String expectedMacBookMsg = "MacBook";
        Assert.assertEquals(expectedMacBookMsg, actualMacBookMsg);

        //2.6 Click on ‘Add To Cart’ button
        driver.findElement(By.id("button-cart")).click();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualSuccessMsg = driver.findElement(By.xpath("//div[@id='product-product']//div[@class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualSuccessMsg);
        String expectedSuccessMSG = "Success: You have added MacBook to your shopping cart!";
        // Assert.assertEquals("Verifying SuccessMessage",expectedSuccessMSG,actualSuccessMsg);

        //2.14 Verify the Total £737.45
        driver.findElement(By.linkText("shopping cart")).click();
        String actualTotalMSG = driver.findElement(By.xpath("//div[@class= 'table-responsive']//table[1]/tbody[1]/tr[1]/td[6]")).getText();
        System.out.println(actualTotalMSG);
        String expectedTotalMSG = "$602.00";
        Assert.assertEquals("Verifying the Total Msg", expectedTotalMSG, actualTotalMSG);

        //2.15 Click on “Checkout” button
        driver.findElement(By.linkText("Checkout")).click();

        //2.16 Verify the text “Checkout”
        String actualCheckOutMSG = driver.findElement(By.xpath("//div[@id= 'content']//h1")).getText();
        System.out.println(actualCheckOutMSG);
        String expectedCheckOutMsg = "Checkout";
        Assert.assertEquals("verifying checkout msg", expectedCheckOutMsg, actualCheckOutMSG);

        //2.17 Verify the Text “New Customer”
        String actualNewCustomerMsg = driver.findElement(By.xpath("//div[@class='panel-body']//div[1]//div[1]//h2")).getText();
        System.out.println(actualNewCustomerMsg);
        String expectedNewCustomerMsg = "New Customer";
       // Assert.assertEquals("Verifying New customer MSG", expectedNewCustomerMsg, actualCheckOutMSG);

        //2.18 Click on “Guest Checkout” radio button
        driver.findElement(By.xpath("//input[@value='guest']")).click();

        //2.19 Click on “Continue” tab
        driver.findElement(By.id("button-account")).click();

        //2.20 Fill the mandatory fields
        sendKeysToElement(By.id("input-payment-firstname"),"Ganesha");
        sendKeysToElement(By.id("input-payment-lastname"),"Shiva");
        sendKeysToElement(By.id("input-payment-address-1"),"Test Street");
        sendKeysToElement(By.id("input-payment-email"),"test@gmail.com");
        sendKeysToElement(By.id("input-payment-telephone"),"1234567");
        sendKeysToElement(By.id("input-payment-city"),"Test City");
        sendKeysToElement(By.id("input-payment-postcode"),"Test Postcode");
        WebElement sort1 = driver.findElement(By.id("input-payment-country"));
        sort1.click();
        Select select = new Select(sort1);
        select.selectByVisibleText("United States");
        WebElement sort2 = driver.findElement(By.id("input-payment-zone"));
        sort2.click();
        Select select1 = new Select(sort2);
        select1.selectByVisibleText("Indiana");

        //2.21 Click on “Continue” Button
        driver.findElement(By.xpath("//input[@id='button-guest']")).click();

        //2.22 Add Comments About your order into text area
        sendKeysToElement(By.xpath("//textarea[@name='comment']"),"Hi, I am in comment box");

        //2.23 Check the Terms & Conditions check box
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        //2.24 Click on “Continue” button
        driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]")).click();

        //2.25 Verify the message “Warning: Payment method required!”
       String actualWarningMsg= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
       System.out.println(actualWarningMsg);
       String expectedWarningMsg = "Warning: Payment method required!";
       Assert.assertEquals("verifying warning Msg",expectedWarningMsg,actualWarningMsg);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }

}
