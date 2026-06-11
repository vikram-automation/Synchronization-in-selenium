import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NewsletterSubscriptionPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qanewsltrpls.ccbp.tech/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement inputel = driver.findElement(By.id("name"));
        inputel.sendKeys("John Doe");
        WebElement buttonel = driver.findElement(By.id("continueName"));
        buttonel.click();
        WebElement phonenumel = driver.findElement(By.id("phonenum"));
        phonenumel.sendKeys("9876543210");
        WebElement continuebtnel = driver.findElement(By.id("continuePhonenum"));
        continuebtnel.click();
        WebElement emailinputel = driver.findElement(By.id("email"));
        emailinputel.sendKeys("johndoe@gmail.com");
        WebElement emailbtnel = driver.findElement(By.id("continueEmail"));
        emailbtnel.click();
        WebElement submitbtnel = driver.findElement(By.id("submit"));
        submitbtnel.click();
        WebElement successmsgel = driver.findElement(By.id("successMessage"));
        System.out.println(successmsgel.getText());
        driver.quit();
    }
}
