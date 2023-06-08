package basepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }
    public void sendKeysToElement(By by, String text){
       WebElement element= driver.findElement(by);
       element.sendKeys(text);
    }

    public void selectByVisibleTextFromDropDown(By by, String value){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void selectDate(){
        String year = "2022";
        String month = "November";
        String date = "30";
        driver.findElement(By.xpath("input-option225")).click();
        while(true){
            String monthYear = driver.findElement(By.xpath("//div[@class= 'datepicker-days']//table[@class='table-condensed'] //tr//th[@class='picker-switch']")).getText();
            String str [] =monthYear.split(" ");
            String mon = str[0];
            String year1 = str[1];
            if(mon.equalsIgnoreCase(month) && year1.equalsIgnoreCase(year)){
                break;

            }else{
                clickOnElement(By.xpath("//div[@class='datepicker-days'] //tr//th[@class='next']"));
            }
        }

        //List<WebElement> listOfDates = driver.findElements(By.xpath())
    }
}
