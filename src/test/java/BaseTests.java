import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

public class BaseTests {
    public static final DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeSuite
    public void beforeTests() {
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel 3 API 30");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "/Users/Пользователь/Downloads/Android-NativeDemoApp-0.2.1.apk");
    }
}
