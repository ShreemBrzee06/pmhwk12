package homepage;

import basepackage.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility
{
String baseUrl = "https://tutorialsninja.com/demo/index.php";
@Before
public void openingBrowser(){
    openBrowser(baseUrl);
}

@Test
public String selectMenu(String menu){
    return menu;

}
 @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
    mouseHoverToElementAndClick(By.xpath("//ul[@class='nav navbar-nav']/li[1]/div[1]//a[@class='see-all']"));
    }

    @After
    public void closingBrowser(){
    closeBrowser();
    }
}
