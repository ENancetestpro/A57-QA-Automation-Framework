import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework23 extends BaseTest {

    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"GoodMusix3.\"";

        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.provideEmail("elliott.nance@testpro.io");
        loginPage.providePassword("HondaAccord2024$");
        loginPage.clickSubmit();

        playlistPage.locatePlaylist();
        playlistPage.contextClickPlaylist();
        playlistPage.clickEditPlaylist();
        playlistPage.enterNewPlaylistName("GoodMusix3");

        Assert.assertEquals(playlistPage.getSuccessMessage(), updatedPlaylistMsg);
    }
}










