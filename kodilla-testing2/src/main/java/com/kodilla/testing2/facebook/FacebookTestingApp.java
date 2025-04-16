package com.kodilla.testing2.facebook;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookTestingApp {


    public static final String XPATH_ALLOW_COOKIES = "//div[contains(@botton, \"createTask\")]/div[1]";



    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        while (!driver.findElement(By.xpath(XPATH_ALLOW_COOKIES)).isDisplayed());

        WebElement allowCookiesButton = driver.findElement(By.xpath(XPATH_ALLOW_COOKIES));
        allowCookiesButton.click();
        driver.close();

//        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
//        searchField.sendKeys("Kodilla"); div  class="x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt"
//        searchField.submit();   class = x1i10hfl xjbqb8w x1ejq31n xd10rxx x1sy0etr x17r0tee x972fbf xcfux6l x1qhh985 xm0m39n x1ypdohk xe8uvvx xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd x16tdsg8 x1hl2dhg xggy1nq x1o1ewxj x3x9cwd x1e5q0jg x13rtm0m x87ps6o x1lku1pv x1a2a7pz x9f619 x3nfvp2 xdt5ytf xl56j7k x1n2onr6 xh8yej3
    }
}
