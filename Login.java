package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://shop.demoqa.com");
        System.out.println("Open Browser, Open URL");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Dismiss")).click();
        System.out.println("Click Dismiss");
        driver.findElement(By.linkText("My Account")).click();
        System.out.println("Click My Account");
        js.executeScript("window.scrollBy(0,500)"); //scroll vertikal 500px

        driver.findElement(By.id("userName")).sendKeys("Nurul");
        System.out.println("Input Username");
        driver.findElement(By.id("password")).sendKeys("Nurul.123");
        System.out.println("Input Password");
        driver.findElement(By.name("Login")).click();
        System.out.println("Click Login");
        js.executeScript("window.scrollBy(0,500)"); //scroll vertikal 500px

        String myAccountName = driver.findElement(By.className("woocommerce-MyAccount-content")).getText();
        System.out.println(myAccountName);
        System.out.println("Testcase Login Berhasil");
        //Assert menngunakan if
        if (myAccountName.equalsIgnoreCase("Hello Nurul (not Nurul? Log out)\n" +
                "                \"From your account dashboard you can view your recent orders, manage your shipping and billing addresses, and edit your password and account details.")) {
            System.out.println("Status: Pass");
        } else {
            System.out.println("Status: Fail");
        }

        delay();
        driver.quit();
        System.out.println("Quit Browser");
    }

    private static void delay() {
        try {
            Thread.sleep(3000); // delay 3 detik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}