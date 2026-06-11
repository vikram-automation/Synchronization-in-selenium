import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentatewayPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qapaygate.ccbp.tech/");
        WebElement cardNumel = driver.findElement(By.id("cardNumber"));
        cardNumel.sendKeys("8943568230912385");
        WebElement expirydateel = driver.findElement(By.id("expiryDate"));
        expirydateel.sendKeys("12/23");
        WebElement cvvel = driver.findElement(By.id("cvv"));
        cvvel.sendKeys("123");
        WebElement paynowbtnel = driver.findElement(By.id("payNowBtn"));
        paynowbtnel.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otp")));
        WebElement otpel = driver.findElement(By.id("otp"));
        otpel.sendKeys("123456");
        WebElement verifybtnel = driver.findElement(By.id("verifyBtn"));
        verifybtnel.click();
        WebElement successcmsgel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-text")));
        System.out.println(successcmsgel.getText());
        driver.quit();

    }
}
