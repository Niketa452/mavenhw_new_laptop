package Homeworktestngmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {

    public static void enterText(By by, String text) {//to enter text at given location
        driver.findElement(by).sendKeys(text);

    }

    public static String getTextFromContent(By by) {//to get text from location
        return driver.findElement(by).getText();

    }

    public static void clickElement(By by) {//to click on given web element
        driver.findElement(by).click();
    }

    public static void waitForClickable(By by, long time) {//wait for element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementVisible(By by, long time) {//wait for element to be visible
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public static void waitForAlertPresent(long time) {//wait for alert to display
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static String randomdate() {//to generate unique number everytime it is called
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
        return format.format(new Date());


    }

    public static void pointcursorToWebelement(By by) {//mouse hover action
        Actions actions = new Actions(driver);//creating instance of action class for mouse hover.
        WebElement menuList = driver.findElement(by);
        actions.moveToElement(menuList).perform();

    }

    public static void launchingChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Webdriver\\chromedriver.exe");//calling the chromedriver path
        driver = new ChromeDriver();//creating chrome driver object
        driver.manage().window().fullscreen();//to maximise the web page.
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//waiting time before opening teh website
    }

    public static void handlingselectByVisibleTesxt(By by, String text) {//handling dropdown by visible text
        Select selectmonth = new Select(driver.findElement(by));
        selectmonth.selectByValue(text);

    }

    public static void handlingselectByValue(By by, String text) {//handling dropdown by visible text
        Select selectmonth = new Select(driver.findElement(by));
        selectmonth.selectByValue(text);

    }

    public static void handlingselectByIndex(By by, int indexnum) {//handling dropdown by visible text
        Select selectmonth = new Select(driver.findElement(by));
        selectmonth.selectByIndex(indexnum);
    }
}