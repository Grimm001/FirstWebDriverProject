package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindOwnersPage {
    private WebDriver findOwnersDriver;

    public FindOwnersPage(WebDriver driver){
        this.findOwnersDriver = driver;
        //this line stashes the constructor in line 7
        // this means that we don't have to write WebDriver driver or findOwnersDriver in the brackets each time
        // makes the code more manageable

    }
    public void AddOwnerButton(){
        findOwnersDriver.findElement(By.xpath("//a[text()='Add Owner']")).click();
    }
}
