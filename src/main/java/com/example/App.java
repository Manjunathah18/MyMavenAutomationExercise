package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {

        // Configure Chrome for Jenkins/Linux (Headless Mode)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // REQUIRED
        options.addArguments("--no-sandbox"); // REQUIRED
        options.addArguments("--disable-dev-shm-usage"); // REQUIRED
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://automationexercise.com/");
            Thread.sleep(3000);

            // Click on Products
            driver.findElement(By.linkText("Products")).click();
            Thread.sleep(3000);

            // Search for product
            WebElement searchBox = driver.findElement(By.id("search_product"));
            searchBox.sendKeys("Tshirt");

            driver.findElement(By.id("submit_search")).click();
            Thread.sleep(3000);

            // Add first product to cart
            driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
            Thread.sleep(5000);

            // Print confirmation
            System.out.println("Product Added to Cart Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
