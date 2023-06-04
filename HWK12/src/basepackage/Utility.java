package basepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility extends BaseTest {

    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();// logout

    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        actions.moveToElement(mouseHoover).click().build().perform();
    }

}
