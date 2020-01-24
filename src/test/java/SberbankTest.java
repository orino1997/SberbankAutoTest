import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class SberbankTest {
    static ChromeDriver chromeDriver;

    @BeforeClass
    public static void testInitialize() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        chromeDriver.manage().window().maximize();
    }

    @AfterClass
    public static void endTest(){
        chromeDriver.close();
        chromeDriver.quit();
    }

    @Test
    public void myTest() {
        chromeDriver.navigate().to("http://www.sberbank.ru/ru/person");

        WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
        chromeDriver.findElement(By.xpath("//a[contains(@class, 'hd-ft-region')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class = 'kit-grid-modal hd-ft-region__modal']")));
        WebElement inputBox = chromeDriver.findElement
                (By.xpath("//input[@class = 'kit-input__control' and @type = 'search']"));
        inputBox.sendKeys("Нижегородская область");
        chromeDriver.findElement(By.xpath("//a[@class = 'kit-link kit-link_m hd-ft-region__city']")).click();
        Assert.assertEquals("Регион не поменялся", "Нижегородская область",
                chromeDriver.findElement(By.xpath("//header//div[@class = 'hd-ft-region__title']/span")).getText());

        WebElement footer = chromeDriver.findElement(By.xpath("//footer"));
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", footer);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer")));

        Assert.assertTrue("Нет иконки фейсбука",
                chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_fb']"))
                        .isDisplayed());
        Assert.assertTrue("Нет иконки твиттера",
                chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_tw']"))
                        .isDisplayed());
        Assert.assertTrue("Нет иконки ютуба",
                chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_yt']"))
                        .isDisplayed());
        Assert.assertTrue("Нет иконки инстаграма",
                chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_ins']"))
                        .isDisplayed());
        Assert.assertTrue("Нет иконки вконтакте",
                chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_vk']"))
                        .isDisplayed());
        Assert.assertTrue("Нет иконки одноклассников",
                chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_ok']"))
                        .isDisplayed());
    }
}
