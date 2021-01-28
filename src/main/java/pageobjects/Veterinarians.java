package pageobjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Veterinarians {

    private WebDriver driver;

    public Veterinarians(WebDriver driver) {
        this.driver = driver;
    }

    public int getNumberOfRadiologyVets(){
        driver.findElement(By.xpath("//a[@title='veterinarians']")).click();
        Assert.assertTrue("Test",driver.findElement(By.xpath("//table[@id='vets']")).isDisplayed());
        List<WebElement> rows = driver.findElement(By.xpath("//table[@id='vets']//tbody")).findElements(By.tagName("tr"));

        int count = rows.size();
        System.out.println("ROW COUNT : "+count);

        int countVet = 0;
        for(WebElement row : rows) {
            var column2 = row.findElements(By.tagName("td")).get(1);
            if (column2.getText().contains("radiology"))
            {
                countVet++;
            }
        }

        return countVet;
        // countVet is declaring the integer to count the number of radiology vets in the rows
        // for loop is iterating through the rows, and looking for the tag name 'td'
        // if the td contains radiology, and increment the radiology vets count
    }

}
