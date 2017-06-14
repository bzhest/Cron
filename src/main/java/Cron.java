import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.ExecuteScript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

/**
 * Created by DWork on 13.06.2017.
 */
public class Cron {
    static int winNumber = 2;
    WebDriver driver;
    WebDriverWait wait;

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 300);
        //driver.get("http://www.ixloo.com/cron/downloadimages?user_id=25705");
        driver.get("http://www.test.live.motorboxx.goxloo.com/");
        List<WebElement> list = driver.findElements(By.tagName("br"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("br")));
        try {
            if (list.size() > 0) {
                run(driver, wait);
            }

        } catch (Exception ex) {
            driver.quit();
        }


    }

    public static void run(WebDriver driver, WebDriverWait wait) throws Exception {
        //driver.get("http://www.ixloo.com/cron/downloadimages?user_id=25705");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.test.live.motorboxx.goxloo.com/','_blank');");
        openNewTab(driver);
        List <WebElement> list = driver.findElements(By.tagName("br"));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("br")));
        if (list.size() > 0) {
            run(driver, wait);
        } else {
            driver.quit();
        }
    }

    public static void openNewTab(WebDriver driver) {

        Set allWindowHandles = driver.getWindowHandles();// возвращает набор дискрипторов окон
        String neededWindow = (String) allWindowHandles.toArray()[winNumber++ - 1];
        driver.switchTo().window(neededWindow);
    }
}
