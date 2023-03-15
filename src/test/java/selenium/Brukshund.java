package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Brukshund {
    @Test
    public void testGoogleSearch() throws InterruptedException {
        //setup skapar vår browser
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver_win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        //Navigera till hemsida
        driver.get("https://brukshundklubben.se/");

        WebElement omOss = driver.findElement(By.cssSelector("#mainnav > ul.navigation-links.d-none.d-lg-block > li:nth-child(5) > a > span"));
        omOss.click();
        //Thread.sleep(1000);
        WebElement OmBruk = driver.findElement(By.cssSelector("#main > div > div.navigation-landingpage > nav > div:nth-child(1) > div > a > div > div > span"));
        OmBruk.click();
        WebElement titel = driver.findElement(By.cssSelector("#main > div > div:nth-child(1) > div.intro-section.block-padding.col > div:nth-child(2) > div > div.publication > p:nth-child(2)"));

        //WebElement result = driver.findElement(By.name("answer"));

        String actual = driver.getTitle();// result.getAttribute("value");
        String expected = "Om Svenska Brukshundklubben - Svenska Brukshundklubben";
        driver.quit();
        assertEquals(expected, actual);
    }
}
