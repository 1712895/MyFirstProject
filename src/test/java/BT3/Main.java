package BT3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
        //BT3
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        login();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div/following-sibling::div/div/following-sibling::div/div/div/div/div")));
        chooseOganize();
        }
    public static void login()
    {
        WebElement txtEmail = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        txtEmail.sendKeys("diemuyen58@gmail.com");
        WebElement txtPassword = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        txtPassword.sendKeys("diemuyen58");
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        btnLogin.click();
    }
    public static void chooseOganize()
    {
        driver.findElement(By.xpath("//div/div/div/following-sibling::div/div/following-sibling::div/div/div/div/div")).click();
    }
    public static void AddPaymentMethod()
    {
        
    }

    }
