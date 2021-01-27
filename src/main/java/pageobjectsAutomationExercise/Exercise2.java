package pageobjectsAutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Exercise2 {

    private WebDriver driver;

    public Exercise2(WebDriver driver){
        this.driver = driver;
    }

    public void replaceText() {
        driver.findElement(By.xpath("//p[8]/input[1]")).clear();
        driver.findElement(By.xpath("//p[8]/input[1]")).sendKeys("1");
        driver.findElement(By.xpath("//p[8]/input[3]")).clear();
        driver.findElement(By.xpath("//p[8]/input[3]")).sendKeys("2");
        driver.findElement(By.xpath("//p[8]/input[5]")).clear();
        driver.findElement(By.xpath("//p[8]/input[5]")).sendKeys("3");
    }

        //Updated Version

    public void UpdateMeLoop(){
        List<WebElement> elements = driver.findElements(By.xpath("//input[@value='Update me']"));

        //can use var but its always best to be explicit in coding

        int i = 1;
        for (WebElement ele:elements) {
            if (ele.isEnabled()) {
                ele.clear();
                ele.sendKeys("" + i + "");
                i++;
            }
        }
    }
}
