package pageobjectsAutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise4 {

    private WebDriver driver;

    public Exercise4 (WebDriver driver){
        this.driver = driver;
    }

    public void byIndexChoice(){
        Select select = new Select(driver.findElement(By.xpath("//p[16]/select[1]")));
        select.selectByIndex(4);

        Select selectAgain = new Select(driver.findElement(By.xpath("//p[16]/select[2]")));
        selectAgain.selectByIndex(6);

        //Stretch goal - match by text
    }
}
