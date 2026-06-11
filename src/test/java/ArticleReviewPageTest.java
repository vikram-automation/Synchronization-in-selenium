import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArticleReviewPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaarticlervw.ccbp.tech/article/");
        WebElement TitleEl = driver.findElement(By.cssSelector("div.article-info>h1:first-child"));
        System.out.println(TitleEl.getText());
        WebElement reviewbuttonel = driver.findElement(By.className("nav-link"));
        reviewbuttonel.click();
        String expectedurl = "https://qaarticlervw.ccbp.tech/review";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String currenturl = driver.getCurrentUrl();
        if(expectedurl.equals(currenturl)){
            System.out.println("Navigated to Review page");
        }else{
            System.out.println("Failed Navigate Revie page");
        }
        // review text area
        String reviewText = "Clear and thoughtful explanation of React's versioning approach.";
        WebElement textareael = driver.findElement(By.id("reviewTextArea"));
        textareael.sendKeys(reviewText);
        WebElement submitreviewbtnel = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitReviewBtn")));
        submitreviewbtnel.click();
        String expectedurl2 = "https://qaarticlervw.ccbp.tech/article";
        wait.until(ExpectedConditions.urlToBe(expectedurl2));
        String currenturl2 = driver.getCurrentUrl();
        if(expectedurl2.equals(currenturl2)){
            System.out.println("Navigated to Article page");
        }else{
            System.out.println("Failed to navigate page");
        }
        driver.quit();

    }
}
