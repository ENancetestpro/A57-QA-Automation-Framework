import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework23 extends BaseTest {


    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"LETSDRIVE.\"";

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
        playlistPage.enterNewPlaylistName("LETSDRIVE");

        // THEN
        Assert.assertEquals(playlistPage.getSuccessMessage(), updatedPlaylistMsg);
        }
        }









