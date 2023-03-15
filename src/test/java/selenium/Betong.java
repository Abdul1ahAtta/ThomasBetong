package selenium;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class Betong {

    WebDriver driver;
    int time = 1000;

    @Before
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver_win32/chromedriver.exe");
        driver.manage().window().maximize();
    }


    @Test
    public void mainPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://thomasbetong.se");
        Thread.sleep(time);
        js.executeScript("window.scrollBy(0,350)","");

        driver.findElement(By.cssSelector("[href='/volym-kalkylator']")).click();
        driver.findElement(By.cssSelector("[href=\"/volym-kalkylator\"]"));
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}