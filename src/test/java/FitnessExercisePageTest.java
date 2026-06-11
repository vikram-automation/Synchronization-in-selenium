import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class FitnessExercisePageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qafitnesslib.ccbp.tech/");
        Wait<WebDriver> Wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500));
        List<WebElement> categoryListel = driver.findElements(By.cssSelector("ul#categoryList li"));
        for (WebElement list : categoryListel) {
            list.click();
            Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#exerciseList div")));
            List<WebElement> exerciseList = driver.findElements(By.cssSelector("div#exerciseList div"));
            for (WebElement newList : exerciseList) {
                newList.click();
                Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.exercise-details-container>h3")));
                WebElement exerciseEl = driver.findElement(By.cssSelector("div.exercise-details-container>h3"));
                System.out.println(exerciseEl.getText());
                List<WebElement> descriptionList = driver.findElements(By.cssSelector("div.exercise-details-container>ol>li"));
                for(WebElement description:descriptionList ){
                    System.out.println(description.getText());
                }


            }
        }
        driver.quit();

    }
}

