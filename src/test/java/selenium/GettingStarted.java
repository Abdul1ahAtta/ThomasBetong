package selenium;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GettingStarted {

    @Test

    public void testGoogleSearch() throws InterruptedException {
    //setup skapar vår browser
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver_win32/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

    //Navigera till hemsida
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");


        //Thread.sleep(1000);  // Let the user actually see something!

    //lägg till första värde
        WebElement searchBox = driver.findElement(By.tagName("input"));
        searchBox.sendKeys("5");

    //lägg till andra värde
        WebElement Box1 = driver.findElement(By.name("n02"));
        Box1.sendKeys("2");

    // räkna ut resultat
        WebElement button = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input"));
        button.click();
    // hämta ut resultat 0ch jämför resultat
        WebElement result = driver.findElement(By.name("answer"));

        String actual = result.getAttribute("value");
        String expected = "7";
        driver.quit();
        assertEquals(expected, actual);


    }

}