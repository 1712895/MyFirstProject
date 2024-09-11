package org.uyentran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        //BT4
        driver.get("https://globedr.com/signin");
        login();

        //updateUserProfile();
        }
    public static void login()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id=\"UserName\"]")));
        WebElement txtEmail = driver.findElement(By.xpath("//div/input[@id=\"UserName\"]"));
        txtEmail.sendKeys("+13434804615");
        WebElement txtPassword = driver.findElement(By.xpath("//div/input[@id=\"Password\"]"));
        txtPassword.sendKeys("12345678");
        WebElement btnLogin = driver.findElement(By.xpath("//div/button[contains(@translate,\"signIn\")]"));
        btnLogin.click();
    }
    public static void updateUserProfile()
    {

    }


    }
