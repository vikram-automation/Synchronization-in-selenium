import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductReviewPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaproductrvw.ccbp.tech/product/n");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement productTitle = driver.findElement(By.className("product-name"));
        System.out.println(productTitle.getText());
        WebElement writereviewBtnel = driver.findElement(By.className("review-btn"));
        writereviewBtnel.click();
        String expectedurl = "https://qaproductrvw.ccbp.tech/review";
        String currenturl = driver.getCurrentUrl();
        if(expectedurl.equals(currenturl)){
            System.out.println("Navigated to Review page");
        }else{
            System.out.println("Navigated to Review page unsuccess");
        }
        WebElement selectratingel = driver.findElement(By.id("ratingSelect"));
        Select dropdownrating = new Select(selectratingel);
        dropdownrating.selectByValue("5");
        // review text
        String reviewText = "Great quality, reasonable price, and high rating. Highly recommended!";
        WebElement Textarea = driver.findElement(By.id("reviewTextArea"));
        Textarea.sendKeys(reviewText);
        WebElement reviewBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitReviewBtn")));
        reviewBtn.click();
        // redirect page
        String expectedurl2 = "https://qaproductrvw.ccbp.tech/product";
        String currenturl2 = driver.getCurrentUrl();
        if(expectedurl2.equals(currenturl2)){
            System.out.println("Navigated to Product page");
        }else{
            System.out.println("Failed to Navigated Product page");
        }
        driver.quit();
    }
}