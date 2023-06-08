package myaccounts;

import basepackage.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void openingBrowser() {
        openBrowser(baseUrl);
    }


    public void selectMyAccountOptions(String option) {

        if (option.equals("Register")) {
            mouseHoverToElementAndClick(By.linkText("Register"));
            //System.out.println("i m in if loop");
        } else if (option.equals("Login")) {
            mouseHoverToElementAndClick(By.linkText("Login"));
            //System.out.println(" im in else if loop ");
        } else if (option.equals("Logout")) {
            clickOnElement(By.linkText("Logout"));

        }
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        mouseHoverToElementAndClick(By.linkText("My Account"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        String actualRegisterMsg = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(actualRegisterMsg);
        String expectedMsg = "Register Account";
        Assert.assertEquals("Verify Register MSG", expectedMsg, actualRegisterMsg);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //1.1 Click on My Account Link.
        mouseHoverToElementAndClick(By.linkText("My Account"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        String actualReturningCustomerMsg = driver.findElement(By.xpath("//div[@class='row']//div[2]//div[1]//h2")).getText();
        System.out.println(actualReturningCustomerMsg);
        String expectedReturningCustomerMsg = "Returning Customer";
        Assert.assertEquals("Verifying Returning Customer Msg", expectedReturningCustomerMsg, actualReturningCustomerMsg);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        mouseHoverToElementAndClick(By.linkText("My Account"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        selectMyAccountOptions("Register");
        //3.3 Enter First Name
        sendKeysToElement(By.id("input-firstname"), "Ganesha");
        //3.4 Enter Last Name
        sendKeysToElement(By.id("input-lastname"), "Shiva");
        //3.5 Enter Email
        sendKeysToElement(By.id("input-email"), "Ganesha11@gmail.com");
        //3.6 Enter Telephone
        sendKeysToElement(By.id("input-telephone"), "01234587203");
        //3.7 Enter Password
        sendKeysToElement(By.id("input-password"), "Test_1234");
        //3.8 Enter Password Confirm
        sendKeysToElement(By.id("input-confirm"), "Test_1234");
        //3.9 Select Subscribe Yes radio button
        driver.findElement(By.xpath("//div[2]//label[1]//input[@name='newsletter']")).click();
        //3.10 Click on Privacy Policy check box
        mouseHoverToElementAndClick(By.xpath("//input[@name='agree']"));
        //3.11 Click on Continue button
        mouseHoverToElementAndClick(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String actualVerifyAccountMsg = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
        System.out.println(actualVerifyAccountMsg);
        String expectedVerifyAccountMsg = "Your Account Has Been Created!";
        Assert.assertEquals("Verifying Account MSG ", expectedVerifyAccountMsg, actualVerifyAccountMsg);
        //3.13 Click on Continue button
        clickOnElement(By.linkText("Continue"));
        //3.14 Click on My Account Link.
        driver.findElement(By.linkText("My Account")).click();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        System.out.println(getTextFromElement(By.xpath("//*[@id=\"content\"]/h1")));
        //3.17 Click on Continue button
        clickOnElement(By.linkText("Continue"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        mouseHoverToElementAndClick(By.linkText("My Account"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        selectMyAccountOptions("Login");
        //4.3 Enter Email address
        sendKeysToElement(By.id("input-email"), "Ganesha11@gmail.com");
        //4.4 /4.5 Enter Password
        sendKeysToElement(By.id("input-password"), "Test_1234");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        String actualMyAcctMsg = driver.findElement(By.xpath("//*[@id=\"content\"]//h2[1]")).getText();
        System.out.println(actualMyAcctMsg);
        String expectedAcctMsg = "My Account";
        Assert.assertEquals("Verifying Acct Msg",expectedAcctMsg,actualMyAcctMsg);
        //4.8 Click on My Account Link.
        driver.findElement(By.linkText("My Account")).click();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        String actualAcctLogOutMsg = driver.findElement(By.xpath("//*[@id=\"content\"]//h1")).getText();
        System.out.println(actualAcctLogOutMsg);
        String expectedAcctLogOutMsg = "Account Logout";
        //4.11 Click on Continue button
         clickOnElement(By.xpath("//div[@class='pull-right']//a[@class='btn btn-primary']"));
    }

    @After
    public void tearDown() {
         closeBrowser();
    }
}
