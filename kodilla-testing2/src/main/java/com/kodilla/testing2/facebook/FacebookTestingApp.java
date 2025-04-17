package com.kodilla.testing2.facebook;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookTestingApp {


    public static final String XPATH_ALLOW_COOKIES = "//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[2]/div[1]";
    public static final String XPATH_LOGIN = "//input[@id='email']";
    public static final String XPATH_PASSWORD = "//input[@id='pass']";
    public static final String XPATH_LOGIN_BUTTON = "//button[@name='login']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        while (!driver.findElement(By.xpath(XPATH_ALLOW_COOKIES)).isDisplayed());

        WebElement allowCookiesButton = driver.findElement(By.xpath(XPATH_ALLOW_COOKIES));
        allowCookiesButton.click();

        WebElement login = driver.findElement(By.xpath(XPATH_LOGIN));
        login.sendKeys("@gmail.com");
        WebElement password = driver.findElement(By.xpath(XPATH_PASSWORD));
        password.sendKeys("cxxxxxx");
        WebElement loginButton = driver.findElement(By.xpath(XPATH_LOGIN_BUTTON));
        loginButton.click();
        driver.close();
    }
}
