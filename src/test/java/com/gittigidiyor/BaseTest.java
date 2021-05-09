package com.gittigidiyor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        String baseUrl = "https://www.gittigidiyor.com/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
//      Chrome is being controlled by automated test software
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        Log4j.startLog("Test  is Starting");
        webDriver.get(baseUrl);
        Log4j.info("Opening Page : " + baseUrl);

    }

    @After
    public void tearDown() {
        Log4j.endLog("Test is Ending");
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
