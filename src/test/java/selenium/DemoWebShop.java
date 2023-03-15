package selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DemoWebShop {
    WebDriver driver;

    @Before
    public void setup() {
        //setup skapar vår browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver_win32/chromedriver.exe");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void Shopping () throws InterruptedException {
        //navigate to website
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        //click on laptop
        WebElement Laptop = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-3 > div > div > div.product-grid.home-page-product-grid > div:nth-child(3) > div > div.picture > a > img"));
        Laptop.click();
        Thread.sleep(1000);

        //Click on add to card
        WebElement AddToCart = driver.findElement(By.cssSelector("#add-to-cart-button-31"));
        AddToCart.click();
        Thread.sleep(1000);

        //Click on Shopping cart
        WebElement ShoppingCart = driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label"));
        AddToCart.click();
        Thread.sleep(1000);

       /* WebElement result = driver.findElement(By.cssSelector(""));
        String actual = result.getText();
        String expected = "± 8 m3";

        assertEquals(expected, actual);*/
    }
}
