package org.app;

import static java.util.concurrent.TimeUnit.MINUTES;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import java.net.MalformedURLException;
import java.net.URL;
import org.configs.ConfigurationFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.driver.CustomWebDriverListener;
import org.openqa.selenium.remote.RemoteWebDriver;

@Timeout(value = 5, unit = MINUTES)
public abstract class BaseTest {
  WebDriver driver;

  @BeforeEach
  void setUp() {
    //DesiredCapabilities capabilities = new DesiredCapabilities();
    //ChromeOptions options = new ChromeOptions();
    //options.addArguments("enable-automation");
//    options.addArguments("--headless");
//    options.addArguments("--window-size=1920,1080");
    //options.addArguments("--no-sandbox");
//    options.addArguments("--disable-extensions");
//    options.addArguments("--dns-prefetch-disable");
    //options.addArguments("--disable-gpu");
//    options.addArguments("--ignore-ssl-errors=yes");
//    options.addArguments("--ignore-certificate-errors");
    //options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems

    //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//
    Configuration.baseUrl = ConfigurationFactory.getConfigurationFactory().getApplicationConfiguration().appUri();
    Configuration.browser = ConfigurationFactory.getConfigurationFactory().getTestConfig().browser();
    Configuration.browserVersion = "120";
    //Configuration.assertionMode = AssertionMode.SOFT;
    Configuration.timeout = 1500L;

//    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//    Configuration.browserCapabilities = capabilities;
    //Configuration.remote = String.format("http://%s:4444/wd/hub/", "172.17.0.4");
    Configuration.remote = "http://localhost:4444/wd/hub/";
    //WebDriverRunner.addListener(new CustomWebDriverListener());
   // driver = WebDriverRunner.getAndCheckWebDriver();
  }

  @AfterEach
  void tearDown() {
    WebDriverRunner.closeWebDriver();
  }

  private RemoteWebDriver setUpRemoteDriver(DesiredCapabilities capabilities) throws MalformedURLException {
    String url = "http://localhost:4444/wd/hub/";
    return new RemoteWebDriver(new URL(url), capabilities);

  }
}
