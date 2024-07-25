package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(css = "input[placeholder='Email Address']")
    private WebElement emailField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "[type='submit']")
    private WebElement loginBtn;

    @FindBy(css = "form[data-testid][class]")    //form[data-testid][class='error']
    private WebElement errorForm;

    //Helper Methods
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        loginBtn.click();
    }
    public boolean isErrorDisplayed() {
        return errorForm.isDisplayed();
    }

    public void login() {
        provideEmail("elliott.nance@testpro.io");
        providePassword("HondaAccord2024$");
        clickSubmit();
    }
}
