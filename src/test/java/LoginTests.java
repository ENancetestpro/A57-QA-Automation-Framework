import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;

public class LoginTests extends BaseTest {

    // Positive Test Case
    @Test
    public void validEmailValidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("elliott.nance@testpro.io");
        loginPage.providePassword("HondaAccord2024$");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    // Negative Test Cases
    @Test
    public void invalidEmailValidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("invalid.email@testpro.io");
        loginPage.providePassword("HondaAccord2024$");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }
    @Test
    public void validEmailInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("elliott.nance@testpro.io");
        loginPage.providePassword("invalidpassword");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Test
    public void emptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }
}