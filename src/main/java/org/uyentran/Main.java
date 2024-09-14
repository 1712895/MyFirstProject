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
    static Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chomeOptions = new ChromeOptions();
        chomeOptions.enableBiDi();

        ChromeDriver driver = new ChromeDriver(chomeOptions);
        driver.manage().window().maximize();

        driver.get("https://globedr.com/signin");
        login();

        }
    public static void login()
    {
        By txtEmail = By.xpath("//input[@id='UserName']");
        By dlCountry = By.xpath("//input[@dropdowntoggle]");
        By txtPassword = By.xpath("//input[@id='Password']");
        By btnLogin = By.xpath("//button[contains(@translate,'signIn')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmail));
        driver.findElement(txtEmail).sendKeys("+13434804615");
        wait.until( d -> {
            WebElement element = driver.findElement(dlCountry);
            if(element!=null)
            {
                String txt = element.getText();
                if (txt!=null && !txt.isEmpty()) return true;
            }
            return false;
                }
        );
        driver.findElement(txtPassword).sendKeys("12345678");
        driver.findElement(btnLogin).click();
    }


    }
