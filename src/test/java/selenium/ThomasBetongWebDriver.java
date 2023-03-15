package selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThomasBetongWebDriver {
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
    public void rectangle() throws InterruptedException {
        //Navigera till hemsida
        driver.get("https://thomasbetong.se/volym-kalkylator");
        driver.manage().window().maximize();
        //Navigate to calculator
        //WebElement VolCal = driver.findElement(By.cssSelector("[href='/volym-kalkylator']"));
        //VolCal.click();

        // select rectangle
        //WebElement rectangle = driver.findElement(By.xpath("//*[@id=\"rt-mainbottom\"]/div/div[3]/div/div/div/div/div[3]/div/a"));
        //rectangle.click();
        Thread.sleep(5000);
        // Enter bredd, höjd, längd
        WebElement Bredd = driver.findElement(By.name("x"));
        Bredd.sendKeys("2");

        WebElement Hojd = driver.findElement(By.name("y"));
        Hojd.sendKeys("2");

        WebElement Langd = driver.findElement(By.name("z"));
        Langd.sendKeys("2");

        WebElement result = driver.findElement(By.xpath("//*[@id=\"quarter-preview\"]/div[1]/div[1]/div[4]"));

        String actual = result.getText();
        String expected = "± 8 m3";

        assertEquals(expected, actual);
    }

    @Test
    public void triangle() throws InterruptedException {
        //Navigera till hemsida
        driver.get("https://thomasbetong.se/volym-kalkylator");
        driver.manage().window().maximize();
        //Navigate to calculator
        //WebElement VolCal = driver.findElement(By.cssSelector("[href='/volym-kalkylator']"));
        //VolCal.click();

        // select triangle
        WebElement triangle = driver.findElement(By.xpath("//*[@id=\"figures\"]/div[2]/img"));
        triangle.click();
        //problem with .click
        Thread.sleep(5000);
        // Enter bredd, höjd, längd
        WebElement Bredd = driver.findElement(By.name("x"));
        Bredd.sendKeys("2");

        WebElement Hojd = driver.findElement(By.name("h"));
        Hojd.sendKeys("2");

        WebElement Langd = driver.findElement(By.name("z"));
        Langd.sendKeys("2");
        Thread.sleep(5000);
        WebElement result = driver.findElement(By.xpath("//*[@id=\"quarter-preview\"]/div[1]/div[2]/div[4]"));

        String actual = result.getText();
        String expected = "± 4 m3";

        assertEquals(expected, actual);
    }


/*String expected = "125";
String actual = result.getText();
actual = actual.replace(" ","");
actual = actual.replace("±","");
actual = actual.replace("m3","");*/
}
