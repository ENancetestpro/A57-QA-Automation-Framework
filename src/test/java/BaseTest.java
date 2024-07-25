import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal <>();
    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public WebDriverWait wait;
    public String url = "https://qa.koel.app/";
    public Actions actions;
    public void navigateToPage() {
        //driver.get(url);
        getDriver().get(url);
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        String browser = System.getProperty("browser", "chrome");
        threadDriver.set(pickBrowser(browser));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        url = BaseURL != null ? BaseURL : url;
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
            threadDriver.remove();
        }
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.155:4444";

        switch(browser) {
            case "firefox": //gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge": //gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge"://gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox"://gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver =  new ChromeDriver(chromeOptions);
        }
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "@hub.lambdatest.com/wd/hub";
        String userName = "hbfitnessandnutrition";
        String accessKey = "3DkqvXjbcv4CggNYQtoIDerZ9yvKOhOexf4JRwhaY1QnMddFSa";
        //Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "126");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "hbfitnessandnutrition");
        ltOptions.put("accessKey", "3DkqvXjbcv4CggNYQtoIDerZ9yvKOhOexf4JRwhaY1QnMddFSa");
        ltOptions.put("project", "Cloud Test");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        capabilities.setCapability("LT: Options" , ltOptions);
        return driver = new RemoteWebDriver(new URL("https://" +userName + ":" +accessKey + hubURL), capabilities);

    }
}
