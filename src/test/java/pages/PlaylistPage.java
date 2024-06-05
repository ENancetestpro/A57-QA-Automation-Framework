package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PlaylistPage extends BasePage {
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    By selectPlaylist = By.cssSelector("a[href='#!/playlist/93561']");
    By contextMenuEdit = By.cssSelector("li[data-testid='playlist-context-menu-edit-93561']");
    By newPlaylistNameField = By.cssSelector("[name='name']");
    By successNotification = By.cssSelector("div.success.show");

    // Methods
    public void locatePlaylist() {
        WebElement playlist = findElement(selectPlaylist);
        actions.moveToElement(playlist).perform();
        playlist.click(); }

    public void contextClickPlaylist() {
        WebElement playlist = findElement(selectPlaylist);
        actions.contextClick(playlist).perform(); }

    public void clickEditPlaylist() {
        WebElement editOption = findElement(contextMenuEdit);
        actions.click(editOption).perform(); }

    public void enterNewPlaylistName(String newName) {
        WebElement nameField = findElement(newPlaylistNameField);
        nameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        nameField.sendKeys(newName);
        nameField.sendKeys(Keys.ENTER); }

    public String getSuccessMessage() {
        WebElement notification = findElement(successNotification);
        return notification.getText(); }
    }