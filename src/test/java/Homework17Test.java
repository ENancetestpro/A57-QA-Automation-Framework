import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17Test {

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

        //Step 2: Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("elliott.nance@testpro.io");
        Thread.sleep(2000);

        //Step 3: Enter Password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("HondaAccord2024$");
        Thread.sleep(2000);

        //Step 4: Click Log In
        WebElement submitBtn = driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();
        Thread.sleep(2000);

        //Step 5: Search for song named "Pluto"
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys("Pluto");
        Thread.sleep(2000);

        //Step 6: Click View All Button
        WebElement viewAllButton = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);

        // Step 7: Click First Song listed
        WebElement firstSong = driver.findElement(By.xpath("//td[@class='title' and text()='Pluto']"));
        firstSong.click();
        Thread.sleep(2000);

        //Step 8: Click "Add To" button
        WebElement addToBtn = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToBtn.click();
        Thread.sleep(2000);

        // Step 9: Choose the Playlist to add the song to
        WebElement partyPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper ul li.playlist"));
        partyPlaylist.click();
        Thread.sleep(2000);


        //Step 10: Verify song added with verify notification
        WebElement successMessage = driver.findElement(By.cssSelector("div.success"));
        Assert.assertEquals(successMessage.getText(), "Added 1 song into \"Party Playlist.\"");
        Thread.sleep(2000);

        //Step 11: Close Browser
        driver.quit();

    }
}
