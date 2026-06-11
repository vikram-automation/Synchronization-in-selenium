import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightBookingPageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaflightbooking.ccbp.tech/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // departure element
        WebElement Departureel = driver.findElement(By.id("departureCity"));
        Departureel.sendKeys("New York");
        // destination city element
        WebElement Destinationel = driver.findElement(By.id("destinationCity"));
        Destinationel.sendKeys("Los Angeles");
        // departure date text element
        WebElement DepartureDateel = driver.findElement(By.id("travelDate"));
        DepartureDateel.sendKeys("01/08/2026");
        // passenger number element
        WebElement passengernumel = driver.findElement(By.id("passengers"));
        passengernumel.sendKeys("2");
        // button element
        WebElement searchFlightEl = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
        searchFlightEl.click();
        // radio button element
        WebElement radiobtnel = driver.findElement(By.cssSelector("input[value='0']"));
        radiobtnel.click();
        // book now button element
        WebElement booknowbtnel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.container button:last-child")));
        booknowbtnel.click();
        // wallet amount
        WebElement walletAmount = driver.findElement(By.cssSelector("div.container p:first-of-type"));
        System.out.println(walletAmount.getText());
        // password input element
         WebElement passwordel = driver.findElement(By.cssSelector("input[type='password']"));
         passwordel.sendKeys("traveler123");
         // pay now button element
        WebElement paynowbtnel = driver.findElement(By.cssSelector("div.container button:last-child"));
        paynowbtnel.click();
        // page dispalyed element
        By successText = By.cssSelector("div.container h2:first-child");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(successText,"Booking Success!"));
        WebElement successPageel = driver.findElement(successText);
        System.out.println(successPageel.getText());
    }
}

