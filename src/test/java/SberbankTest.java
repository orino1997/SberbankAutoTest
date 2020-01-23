import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class SberbankTest {
    @Test
    public void myTest() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("http://www.sberbank.ru/ru/person");

        WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
        chromeDriver.findElement(By.xpath("//a[contains(@class, 'hd-ft-region')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'kit-grid-modal hd-ft-region__modal']")));
        WebElement inputBox = chromeDriver.findElement(By.xpath("//input[@class = 'kit-input__control' and @type = 'search']"));
        inputBox.click();
        inputBox.sendKeys("Нижегородская область");

        WebElement region = chromeDriver.findElement(By.xpath("//a[@class = 'kit-link kit-link_m hd-ft-region__city']"));
        region.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label = 'Текущий регион: Нижегородская область, изменить регион']")));

        WebElement footer = chromeDriver.findElement(By.xpath("//footer"));
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", footer);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer")));


        WebElement fbLogo = chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_fb']"));
        fbLogo.isDisplayed();
        WebElement twLogo = chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_tw']"));
        twLogo.isDisplayed();
        WebElement ytLogo = chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_yt']"));
        ytLogo.isDisplayed();
        WebElement insLogo = chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_ins']"));
        insLogo.isDisplayed();
        WebElement vkLogo = chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_vk']"));
        vkLogo.isDisplayed();
        WebElement okLogo = chromeDriver.findElement(By.xpath("//span[@class = 'footer__social_logo footer__social_ok']"));
        okLogo.isDisplayed();

        chromeDriver.close();
        chromeDriver.quit();

    }
}
