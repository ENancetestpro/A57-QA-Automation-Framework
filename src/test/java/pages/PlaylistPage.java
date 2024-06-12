package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage {

    @FindBy(css = "a[href='#!/playlist/93561']")
    private WebElement selectPlaylist;

    @FindBy(css = "li[data-testid='playlist-context-menu-edit-93561']")
    private WebElement contextMenuEdit;

    @FindBy(css = "[name='name']")
    private WebElement newPlaylistNameField;

    @FindBy(css = "div.success.show")
    private WebElement successNotification;

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    public void locatePlaylist() {
        actions.moveToElement(selectPlaylist).perform();
        selectPlaylist.click();
    }

    public void contextClickPlaylist() {
        actions.contextClick(selectPlaylist).perform();
    }

    public void clickEditPlaylist() {
        actions.click(contextMenuEdit).perform();
    }

    public void enterNewPlaylistName(String newName) {
        newPlaylistNameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        newPlaylistNameField.sendKeys(newName);
        newPlaylistNameField.sendKeys(Keys.ENTER);
    }

    public String getSuccessMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successNotification));
            return successNotification.getText();
        } catch (TimeoutException e) {
            // Log additional debugging information here
            System.out.println("Element not found within the timeout period: " + e.getMessage());
            // Optionally, take a screenshot or log the page source
            return "Element not found";
        }
    }
}