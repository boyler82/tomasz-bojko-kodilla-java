package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CrudAppTest {

    private static final String BASE_URL = "https://boyler82.github.io/tasksApp/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        try {
            // Sprawdź, czy jest alert, jeśli tak – zamknij
            Alert alert = driver.switchTo().alert();
            alert.accept(); // lub alert.dismiss(); jeśli chcesz "anulować"
        } catch (Exception e) {
            // Brak alertu – ignorujemy
        }
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
//        Thread.sleep(3000);

        final String XPATH_TASK_NAME = "//form[contains(@action,\"v1/tasks\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"v1/tasks\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"v1/tasks\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }


    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()           // [3]
                .filter(anyForm ->                                             // [4]
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")) // [5]
                                .getText().equals(taskName))                        // [6]
                .forEach(theForm -> {                                          // [7]
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));    // [8]
                    Select select = new Select(selectElement);                 // [9]
                    select.selectByIndex(1);                                   // [10]

                    WebElement buttonCreateCard =                              // [11]
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]")); // [12]
                    buttonCreateCard.click();

                    try {
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                        alert.accept();
                    } catch (Exception e) {
                        System.out.println("Brak alertu po kliknięciu przycisku utworzenia karty.");
                    }
                });

        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);	// [1]
        driverTrello.get(TRELLO_URL);                                                // [2]
        Thread.sleep(4000);								                            // [6]


        driverTrello.findElement(By.id("username")).sendKeys("@gmail.com");
        driverTrello.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);								                            // [6]
        driverTrello.findElement(By.id("password")).sendKeys("cxxxxxx");		    // [4]
        WebElement el = driverTrello.findElement(By.id("login-submit"));
        el.submit();									                                // [5]

        Thread.sleep(4000);								                            // [6]

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()   // [9]
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)  // [10]
                .forEach(WebElement::click);						                        // [11]

        Thread.sleep(4000);								                            // [12]

        result = driverTrello.findElements(By.xpath("//span")).stream()		        // [13]
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));    		        // [14]
        Thread.sleep(4000);								                            // [12]

        driverTrello.close();							                            // [15]

        return result;								                                // [16]
    }

    private void deleteTestTaskFromCrudApp(String taskName) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);

        driver.findElements(By.xpath("//form[@class='datatable__row']")).stream()
                .filter(form -> form.findElement(By.xpath(".//p[@class='datatable__field-value']")).getText().equals(taskName))
                .forEach(form -> {
                    WebElement deleteButton = form.findElement(By.xpath(".//button[4]"));
                    deleteButton.click();
                });

        Thread.sleep(2000);
    }


    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));   // [1]
        deleteTestTaskFromCrudApp(taskName);
    }

}