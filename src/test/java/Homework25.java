import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework25 extends BaseTest {

    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"Relax.\"";

        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.provideEmail("elliott.nance@testpro.io");
        loginPage.providePassword("HondaAccord2024$");
        loginPage.clickSubmit();

        playlistPage.locatePlaylist();
        playlistPage.contextClickPlaylist();
        playlistPage.clickEditPlaylist();
        playlistPage.enterNewPlaylistName("Relax");

        String actualMessage = playlistPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, updatedPlaylistMsg, "The success message did not match.");    }
}










