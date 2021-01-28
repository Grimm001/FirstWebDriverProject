package pageobjects;

import dataobjects.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddOwnerOnFind {
    private WebDriver addOwnerDriver;
    private By firstnameInput = By.xpath("//input[@id='firstName']");
    private By lastnameInput = By.xpath("//input[@id='lastName']");
    private By addressInput = By.xpath("//input[@id='address']");
    private By cityInput = By.xpath("//input[@id='city']");
    private By contactnumberInput = By.xpath("//input[@id='telephone']");
    private By addownerButton = By.xpath("//button[contains(text(),'Add Owner')]");

    //Page Factory Approach
    //@FindBy is an annotation that tells the next line is an @Test method
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstnameinput2;


    public AddOwnerOnFind(WebDriver driver) {
        this.addOwnerDriver = driver;

    }
    //Hard code
    public void OwnerInput(){
        addOwnerDriver.findElement(firstnameInput).sendKeys("Ben");
        addOwnerDriver.findElement(lastnameInput).sendKeys("Grimstead");
        addOwnerDriver.findElement(addressInput).sendKeys("Test 01, Test Street");
        addOwnerDriver.findElement(cityInput).sendKeys("Test City");
        addOwnerDriver.findElement(contactnumberInput).sendKeys("0123456789");
        addOwnerDriver.findElement(addownerButton).click();

        // This is how you would call the element by the page factory
        // This is just an example of a different way that you can code privately
        // Line 39 is just a different way that you can play around with object types with the .properties
        firstnameinput2.sendKeys("Ben");
        WebElement fryingPan = addOwnerDriver.findElement(firstnameInput);
        fryingPan.clear();
        fryingPan.click();
    }
    //Pass in the objects custom - simple for a few options, but can get ridiculous
    public void OwnerInput(String firstName, String lastName, String address, String city, String contactNumber){
        addOwnerDriver.findElement(firstnameInput).sendKeys(firstName);
        addOwnerDriver.findElement(lastnameInput).sendKeys(lastName);
        addOwnerDriver.findElement(addressInput).sendKeys(address);
        addOwnerDriver.findElement(cityInput).sendKeys(city);
        addOwnerDriver.findElement(contactnumberInput).sendKeys(contactNumber);
        addOwnerDriver.findElement(addownerButton).click();

        //they can have the same method name however as long as the signatures of the method are different then they can be used
        // example, the first method has hard coded parameters for the data
        //the second one allows the user to re-use the method and call it multiple times with different data fields
        //BDD
    }
    //POJO is where we store all the objects in a basic class and call the class under one name and pick and choose what we want from it
    // POJO data doesn't have to be stored in the script
    public void OwnerInput(UserData userData){
        addOwnerDriver.findElement(firstnameInput).sendKeys(userData.firstName);
        addOwnerDriver.findElement(lastnameInput).sendKeys(userData.lastName);
        addOwnerDriver.findElement(addressInput).sendKeys(userData.address);
        addOwnerDriver.findElement(cityInput).sendKeys(userData.city);
        addOwnerDriver.findElement(contactnumberInput).sendKeys(userData.contactNumber);
        addOwnerDriver.findElement(addownerButton).click();

    }
}
