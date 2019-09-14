package Homeworktestngmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestngMAven extends Utils {
    LoadPoperties props = new LoadPoperties();

    @BeforeMethod
    public void setup(){
        launchingChromeDriver();
        driver.get(props.getProperty("url"));//web page url given
        }
    @Test
    public void userShouldBeAbleToRegisterSuccessfulluy(){

        clickElement(By.xpath("//a[@class='ico-register']"));
        //driver.findElement(By.xpath("//a[@class='ico-register']")).click();//to click on register button for registration

        //driver.findElement(By.id("FirstName")).sendKeys("Niketa");//registration form compulsory fields to be filled, Enter name
        enterText (By.id("FirstName"), props.getProperty("FirstName"));

        //driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("Parekh");//Enter surname
        enterText(By.xpath("//input[@name='LastName']"),props.getProperty("LastName"));

        //Selecting date from the dropdown list
        handlingselectByVisibleTesxt(By.xpath("//select[@name='DateOfBirthDay']"), "5");

        //Selecting month from the dropdown list
        handlingselectByValue(By.xpath("//select[@name='DateOfBirthMonth']"), "8");

        //Selecting year from the dropdown list
        handlingselectByIndex(By.xpath("//select[@name='DateOfBirthYear']"), 90);

        //driver.findElement(By.name("Email")).sendKeys("Abc"+randomdate()+"@gmail.com" );//Enter email
        enterText(By.name("Email"),props.getProperty("Emailstart")+randomdate()+ props.getProperty("Emailend"));

        //driver.findElement(By.id("Password")).sendKeys("london26");//Enter password
        enterText(By.id("Password"),props.getProperty("Password"));

        //driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("london26");//Enter Confirm password
        enterText(By.xpath("//input[@name='ConfirmPassword']"), props.getProperty("Password"));

        //driver.findElement(By.xpath("//input[@type='submit' and @name='register-button']")).click();//click on register button
        clickElement(By.xpath("//input[@type='submit' and @name='register-button']"));

        String actualMessage = getTextFromContent(By.className("result"));
        //driver.findElement(By.className("result")).getText();//storing value of actual message in a string variable

        String expectedMessage = "Your registration completed";//actual display message
        System.out.println("Actual message is : " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);//validating acutal with expected


    }
    @Test
    public void emailAProductToAFriend() {
        userShouldBeAbleToRegisterSuccessfulluy();
        //driver.findElement(By.xpath("//img")).click();//returning back to the home page for purchasing
        clickElement(By.xpath("//img"));

        //driver.findElement(By.linkText("Computers")).click();//click on computers category
        clickElement(By.linkText("Computers"));

        //driver.findElement(By.linkText("Notebooks")).click();//click on notebook category
        clickElement(By.linkText("Notebooks"));

        //driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();//selecting preferred notebook
        clickElement(By.linkText("Apple MacBook Pro 13-inch"));

        //driver.findElement(By.xpath("//input[@value='Email a friend']")).click();//clicking on the email a friend button to refer the product
        clickElement(By.xpath("//input[@value='Email a friend']"));

        //driver.findElement(By.className("friend-email")).sendKeys("karishma@gmail.com");//Enter friend's email address
        enterText(By.className("friend-email"), props.getProperty("FriendEmail"));

        //driver.findelement (By.xpath("//textarea")).sendKeys("Hi, this looks great. Consider buying?")//message to a friend
        enterText(By.xpath("//textarea"), props.getProperty("MessageToAFriend"));

        //driver.findElement(By.name("send-email")).click();//Click on send button
        clickElement(By.name("send-email"));

        //driver.findElement(By.xpath("//textarea")).sendKeys("Hi, this looks like a great product. Consider buying?");
        //Thread.sleep(5000);//waiting time before closing

        String actualmessage=getTextFromContent(By.xpath("//div[@class='result']"));
                //driver.findElement(By.xpath("//div[@class='result']")).getText();//getting actual text from the webpage

        String expectedconfirmationmessage = "Your message has been sent.";//storing expected message in a string variable
        System.out.println("Acutal confirmation message is : "+actualmessage);//
        Assert.assertEquals(actualmessage,expectedconfirmationmessage);//comparing actual result with expected.
    }

    @Test
    public void userShouldBeAbleToNavigateToCameraAndPhotoPage(){
        pointcursorToWebelement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
        //Actions actions = new Actions(driver);//creating instance of action class for mouse hover.
        //ebElement electronicsMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));//storing location of dropdown in webelement variable
        //actions.moveToElement(electronicsMenu).perform();


        clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));
        //driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));
        //selectElectronics.click();//selecting and clicking camera and photo subcategory.


        String actual_msg = getTextFromContent(By.xpath("//h1"));
        //driver.findElement(By.xpath("//h1")).getText();//getting and storing actual display message.

        String expected_msg = "Camera & photo";
        System.out.println("Actual tittle displayed is : "+actual_msg);
        Assert.assertEquals(actual_msg, expected_msg);//validating actual message with the expected message
    }
    @Test
    public void userShouldBeAbleToFilterJewelleryByPrice() {
        String ans;
        clickElement(By.xpath(" //ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry')]"));
        //driver.findElement(By.xpath(" //ul[@class='top-menu notmobile']//a[contains(text(),'Jewelry')]")).click();//clicking on 'Jewellery' on the homepage.

        clickElement(By.cssSelector("a[href='//demo.nopcommerce.com/jewelry?price=700-3000']"));
        //driver.findElement(By.cssSelector("a[href='//demo.nopcommerce.com/jewelry?price=700-3000']")).click();//clicking on the filter attribute of range $700-$3000

        String price =getTextFromContent(By.xpath("//span[@class='price actual-price']"));
                //driver.findElement(By.xpath("//span[@class='price actual-price']")).getText();//getting and storing text according to the filter selected.

        System.out.println(price);
        price = price.substring(0, 6);//to eliminate junk characters and converting string to integer value.
        price = price.replaceAll("[^0-9]", "");
        int x = Integer.parseInt(price);
        if (x >= 700 && x <= 3000) {//checking the filter function
            ans = "PASSED";
            System.out.println("Your test has " + ans);
        } else {

            ans = "FAILED";
            System.out.println("Your test has " + ans);

        }
        String pageTitle=getTextFromContent(By.xpath("//h1[contains(text(),'Jewelry')]"));
                //driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]")).getText();//verifying user is navigated to jewllery page

        String actual_title="Jewelry";
        System.out.println("you are navigated to : "+actual_title+ " page." );
        Assert.assertEquals(pageTitle,actual_title);
    }
    @Test
    public void userShouldBeAbleToAddTheProductsToTheShoppingCart()throws InterruptedException{

        clickElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        //driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]")).click();//clicking on books link

        clickElement(By.xpath("//img[@alt='Picture of Fahrenheit 451 by Ray Bradbury']"));
        //driver.findElement(By.xpath("//img[@alt='Picture of Fahrenheit 451 by Ray Bradbury']")).click();//Clicking on a book

        clickElement(By.cssSelector("#add-to-cart-button-37"));
        //driver.findElement(By.cssSelector("#add-to-cart-button-37")).click();//adding a book to the cart

        clickElement(By.xpath("//span[contains(text(),'Books')]"));
        //driver.findElement(By.xpath("//span[contains(text(),'Books')]")).click();//clicking on books link

        clickElement(By.cssSelector("img[title$='Prejudice']"));
        //driver.findElement(By.cssSelector("img[title$='Prejudice']")).click();//selecting another book to add to cart

        clickElement(By.cssSelector("#add-to-cart-button-39"));
        //driver.findElement(By.cssSelector("#add-to-cart-button-39")).click();//adding to cart

        Thread.sleep(5000);//instructing browser to wait

        clickElement(By.xpath("//span[@class='cart-label']"));
        //driver.findElement(By.xpath("//span[@class='cart-label']")).click();//clicking on shopping cart lable to view the products added

        pointcursorToWebelement(By.xpath("//span[@class='cart-label']"));
        //Actions actions = new Actions(driver);//creating instance of Action class
        //WebElement shoppincart = driver.findElement(By.xpath("//span[@class='cart-label']"));//storing webelement in a variable
        //actions.moveToElement(shoppincart).perform();//storing and getting string value in a variable

        String qty =getTextFromContent(By.xpath("//span[@class='cart-qty']"));
                //driver.findElement(By.xpath("//span[@class='cart-qty']")).getText();

        System.out.println("Actual quantity ordered : " + qty);
        String expected_qty = "(2)";
        Assert.assertEquals(qty, expected_qty);//validating that shopping cart shows exact number of products shopped
    }

   @AfterMethod
    public void teardownr(){

        driver.quit();


    }

}


