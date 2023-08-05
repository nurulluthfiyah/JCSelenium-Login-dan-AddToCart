package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProduct {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com");
        System.out.println("Open Browser, Open URL");

        driver.findElement(By.linkText("Dismiss")).click();
        System.out.println("Click Dismiss");
        driver.findElement(By.linkText("My Account")).click();
        System.out.println("Click My Account");
        js.executeScript("window.scrollBy(0,500)"); //scroll vertikal 500px

        driver.findElement(By.id("userName")).sendKeys("Nurulluthfiyah");
        System.out.println("Input Username");
        driver.findElement(By.id("password")).sendKeys("noorel99");
        System.out.println("Input Password");
        driver.findElement(By.name("Login")).click();
        System.out.println("Click Login");
        js.executeScript("window.scrollBy(0,500)"); //scroll vertikal 500px

        driver.findElement(By.className("cart-button")).click();
        System.out.println("Click Cart");
        driver.findElement(By.xpath("//a[contains(text(),'Return to shop')]")).click();
        System.out.println("CLick return to Shop");
        js.executeScript("window.scrollBy(0,500)"); //scroll vertikal 500px

        driver.findElement(By.className("noo-product-inner")).click();
        System.out.println("Choose Product");
        js.executeScript("window.scrollBy(0,500)"); //scroll vertikal 500px

        driver.findElement(By.id("pa_color")).sendKeys("White");
        delay();
        driver.findElement(By.id("pa_size")).sendKeys("S");
        delay();
        driver.findElement(By.className("single_add_to_cart_button")).click();
        delay();
        System.out.println("Click Button Add to Cart");

        String addToCartSuccess = driver.findElement(By.className("woocommerce-message")).getText();
        System.out.println(addToCartSuccess);
        System.out.println("Test Case Add Product to Cart Success");
        //Assert menggunakan if
        if (addToCartSuccess.equalsIgnoreCase("view cart\n" + "“Tokyo Talkies” has been added to your cart.")){
            System.out.println("Status: Pass");
        } else {
            System.out.println("Status: Fail");
        }

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
