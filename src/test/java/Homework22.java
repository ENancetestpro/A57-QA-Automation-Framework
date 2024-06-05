import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework22 extends BaseTest {


    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"TRAVEL.\"";

        // GIVEN
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.provideEmail("elliott.nance@testpro.io");
        loginPage.providePassword("HondaAccord2024$");
        loginPage.clickSubmit();

        // WHEN
        playlistPage.locatePlaylist();
        playlistPage.contextClickPlaylist();
        playlistPage.clickEditPlaylist();
        playlistPage.enterNewPlaylistName("TRAVEL");

        // THEN
        Assert.assertEquals(playlistPage.getSuccessMessage(), updatedPlaylistMsg);
        }
        }









