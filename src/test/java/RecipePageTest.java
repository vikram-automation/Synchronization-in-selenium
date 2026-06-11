import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class RecipePageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qarecipepage.ccbp.tech/");
        Wait<WebDriver> Wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500));
        List<WebElement> categoryList = driver.findElements(By.cssSelector("ul#categoryList li"));
        for(WebElement list:categoryList){
            list.click();
            Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#recipeList>ul li")));
            List<WebElement> recipeList = driver.findElements(By.cssSelector("div#recipeList>ul li"));
            for(WebElement list2:recipeList){
                list2.click();
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#recipe>h3")));
                WebElement recipeEl = driver.findElement(By.cssSelector("div#recipe>h3"));
                System.out.println(recipeEl.getText());
                List<WebElement> ingrediantList = driver.findElements(By.cssSelector("div#recipe>ul li"));
                for(WebElement ingrediants:ingrediantList){
                    System.out.println(ingrediants.getText());
                }


            }
        }
    }
}
