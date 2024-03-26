import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16Test {

    @Test
    public void registrationNavigation() throws InterruptedException {
        ///Pre-Condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //ChromeDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //STEPS
        //Step 1: OpenBrowser
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        //Step 2: Click on Registration Link
        WebElement registrationBtn = driver.findElement(By.cssSelector("[href='registration']"));
        registrationBtn.click();
        //Step 3: Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("elliott.nance+4@testpro.io");
        Thread.sleep(2000);
        //Step 4: Click on Submit
        WebElement submitBtn = driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();
        Thread.sleep(2000);
        //Step 5: Verify registration success message
        WebElement successMessage = driver.findElement(By.cssSelector("div.messages"));
        Assert.assertEquals(successMessage.getText(), "We've sent a confirmation link to the email. Please continue by clicking on it");
        //Step 6: Close Browser
        driver.quit();

    }
}
