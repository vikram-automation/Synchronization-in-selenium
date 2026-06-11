import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WorkshopEnrollmentPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaworkshopenrl.ccbp.tech/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // type 1 explicit wait defining
        WebElement inputel = driver.findElement(By.id("name"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        inputel.sendKeys("George");
        WebElement buttonel = driver.findElement(By.id("continueName"));
        buttonel.click();
        // type 2 explicit wait defining
        WebElement emailel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailel.sendKeys("george@gmail.com");
        WebElement emailbuttonel = driver.findElement(By.id("continueEmail"));
        emailbuttonel.click();
        // type 3 explicit wait defining
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react")));
        WebElement reactradiobtnel = driver.findElement(By.id("react"));
        reactradiobtnel.click();
        // dropdown element
        WebElement dropdownel = driver.findElement(By.id("slot"));
        Select slotlist = new Select((dropdownel));
        slotlist.selectByValue("eleven");
        WebElement enrollbtn = driver.findElement(By.id("submit"));
        enrollbtn.click();
        WebElement successText = driver.findElement(By.id("successMessage"));
        wait.until(ExpectedConditions.textToBePresentInElement(successText,"Subscribed successfully"));
        System.out.println(successText.getText());
        driver.quit();


    }
}
