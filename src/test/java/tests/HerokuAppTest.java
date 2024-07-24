package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HerokuAppTest {
    @Test
    public void inputTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1024, 700));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        Cookie cookie = new Cookie("ekfme", "evkev");
//        driver.manage().addCookie(cookie);
        driver.get("http://the-internet.herokuapp.com/inputs");//открываем страницу в браузере хром
//        System.out.println(driver.getWindowHandle());
        WebElement inputField = driver.findElement(By.xpath("//*[@type='number']"));
        inputField.sendKeys("20");
        String actualText = inputField.getAttribute("value"); //20
        Assert.assertEquals(actualText, "20");


        inputField.sendKeys(Keys.ARROW_UP);
        String actualText1 = inputField.getAttribute("value"); //21
        Assert.assertEquals(actualText1, "21");

    }
}
