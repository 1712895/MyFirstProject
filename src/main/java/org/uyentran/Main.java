package org.uyentran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static WebDriver driver = new ChromeDriver();
    static Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chomeOptions = new ChromeOptions();
        chomeOptions.enableBiDi();

        ChromeDriver driver = new ChromeDriver(chomeOptions);
        driver.manage().window().maximize();

        driver.get("https://globedr.com/signin");
        login(); //Ko chay duoc -> Chua kiem duoc bug

        }
    public static void login()
    {
        By txtUserName = By.xpath("//input[@id='UserName']");
        By dlCountry = By.xpath("//button[@dropdowntoggle]");
        By txtPassword = By.xpath("//input[@id='Password']");
        By btnLogin = By.xpath("//button[contains(@translate,'signIn')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUserName));
        driver.findElement(txtUserName).sendKeys("+13434804615"); //Test case: SDT Canada (+1)
        wait.until( d -> {
            WebElement element = driver.findElement(dlCountry);
            if(element!=null)
            {
                String txt = element.getText();
                return txt != null && !txt.isEmpty();
            }
            return false;
                }
        );
        driver.findElement(txtPassword).sendKeys("12345678");
        driver.findElement(btnLogin).click();
    }


    }
