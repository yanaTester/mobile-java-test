import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class LoginTests extends BaseTests{

    @Test
    public void checkValidEmailAndPasswordTest() throws Exception{
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(2000);

        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(2000);

        MobileElement inputEmail = (MobileElement) driver.findElementByAccessibilityId("input-email");
        inputEmail.sendKeys("test@gmail.com");
        MobileElement inputPassword = (MobileElement) driver.findElementByAccessibilityId("input-password");
        inputPassword.sendKeys("qwerty123");
        Thread.sleep(2000);

        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
        Thread.sleep(2000);

        WebElement successLogin = driver.findElementById("android:id/message");
        Assert.assertEquals(successLogin.getText(), "You are logged in!");
    }

    @Test
    public void checkEmptyEmailAndPasswordTest() throws Exception {
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(2000);

        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(2000);

        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
        Thread.sleep(2000);

        MobileElement errorEmail = (MobileElement) driver.findElementByXPath
                ("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/" +
                        "android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
        Assert.assertEquals(errorEmail.getText(), "Please enter a valid email address");

        MobileElement errorPassword = (MobileElement) driver.findElementByXPath
                ("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/" +
                        "android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");
        Assert.assertEquals(errorPassword.getText(), "Please enter at least 8 characters");
    }

    @Test
    public void checkSpacesInThePasswordTest() throws Exception {
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(2000);

        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(2000);

        MobileElement inputEmail = (MobileElement) driver.findElementByAccessibilityId("input-email");
        inputEmail.sendKeys("test@gmail.com");
        MobileElement inputPassword = (MobileElement) driver.findElementByAccessibilityId("input-password");
        inputPassword.sendKeys("        ");
        Thread.sleep(2000);

        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
        Thread.sleep(2000);

        WebElement successLogin = driver.findElementById("android:id/message");
        Assert.assertEquals(successLogin.getText(), "You are logged in!");
    }
}

