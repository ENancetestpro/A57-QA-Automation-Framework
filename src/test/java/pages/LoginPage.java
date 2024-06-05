package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web Elements
    By emailField = By.cssSelector("input[placeholder='Email Address']");
    By passwordField = By.cssSelector("input[type='password']");
    By loginBtn =By.cssSelector("[type='submit']");

    //Helper Methods
    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement(loginBtn).click();
    }
    public void login(){
        provideEmail("elliott.nance@testpro.io");
        providePassword("HondaAccord2024$");
        clickSubmit();
    }
}
