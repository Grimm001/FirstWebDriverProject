package pageobjectsAutomationExercise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Exercise6 {
    private WebDriver driver;

    public Exercise6 (WebDriver driver){
        this.driver = driver;
    }

    public void PushTheButton(){
        driver.findElement(By.xpath("//p[24]/input[1]")).click();

        Alert confirmation = driver.switchTo().alert();
        String alertText = confirmation.getText();
        confirmation.accept();
        driver.findElement(By.xpath("//p[24]/input[2]")).clear();
        driver.findElement(By.xpath("//p[24]/input[2]")).sendKeys(alertText);

        //push the button
        //Code which switches to the alert
        //Should store the alertText as a string, and then confirm it.
        //Clear the box
        //Replace with stored input from, alertText


    }
}
