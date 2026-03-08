package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Products")).click();
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.id("search_product"));
        searchBox.sendKeys("Tshirt");
        driver.findElement(By.id("submit_search")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
        Thread.sleep(5000);
        System.out.println("Product Added to Cart Successfully");
        driver.quit();
    }
}
