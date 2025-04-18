package com.kodilla.testing2.ebuy;


import com.kodilla.testing2.ebuy.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTestingApp {
    public static final String SEARCHFIELD = "_nkw";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.ebay.pl");

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("laptop");
        searchField.submit();
    }
}
