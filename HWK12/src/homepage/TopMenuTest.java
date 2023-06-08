package homepage;

import basepackage.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void openingBrowser() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[1]//a[@class='dropdown-toggle']"));
        mouseHoverToElementAndClick(By.linkText("Show AllDesktops"));
        String actualDeskTopMSG = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
        System.out.println(actualDeskTopMSG);
        String expectedDeskTopMsg = "Desktops";
        Assert.assertEquals("Verifying Desktop pg Msg:", expectedDeskTopMsg, actualDeskTopMSG);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[2]//a[@class='dropdown-toggle']"));
        mouseHoverToElementAndClick(By.linkText("Show AllLaptops & Notebooks"));
        String actualLaptopMsg = driver.findElement(By.xpath("//div[@id='content']/h2[1]")).getText();
        System.out.println(actualLaptopMsg);
        String expectedLandNPg = "Laptops & Notebooks";
        Assert.assertEquals("Verifying LaptopndNotebook pg Msg:", expectedLandNPg, actualLaptopMsg);

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[3]//a[@class='dropdown-toggle']"));
        mouseHoverToElementAndClick(By.linkText("Show AllComponents"));
        String actualComponentMsg = driver.findElement(By.xpath("//div[@id='content']/h2[1]")).getText();
        System.out.println(actualComponentMsg);
        String expectedComponentPg = "Components";
        Assert.assertEquals("Verifying Components pg Msg:", expectedComponentPg, actualComponentMsg);
    }

    @After
    public void closingBrowser() {
        closeBrowser();
    }
}
