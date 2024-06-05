package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaylistPage extends BasePage {
    
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = "a[href='#!/playlist/93561']")
    private WebElement selectPlaylist;
    @FindBy(css = "li[data-testid='playlist-context-menu-edit-93561']")
    private WebElement contextMenuEdit;
    @FindBy(css = "[name='name']")
    private WebElement newPlaylistNameField;
    @FindBy(css = "div.success.show")
    private WebElement successNotification;

    // Methods
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
        return successNotification.getText();
    }
}