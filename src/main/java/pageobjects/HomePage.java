package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver homepageDriver;

    public HomePage(WebDriver constructorDriver){
        this.homepageDriver = constructorDriver;
        //takes the constructorDriver and assigns it to homepageDriver
        //homepageDriver is private but accessible everywhere in this class ONLY
        //we called it homepageDriver to differenciate driver as this was confusing me, dont hate me John
    }

    public void findOwners(String lastname) {
        homepageDriver.findElement(By.xpath("//a[@title='find owners']")).click();
        homepageDriver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
        homepageDriver.findElement(By.xpath("//button[@type='submit']")).click();
        // wait for field with last name and check the value is displayed
    }

    public AddOwnerOnFind findOwnerToAdd(WebDriver driver)
    {
        driver.findElement(By.xpath("//a[@title='find owners']")).click();
        driver.findElement(By.xpath("//a[@title='Add owner']")).click();
        return new AddOwnerOnFind(driver);
    }

    public void clickfindOwners(){
        homepageDriver.findElement(By.xpath("//a[@title='find owners']")).click();

    }
}

