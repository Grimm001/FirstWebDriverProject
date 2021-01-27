package pageobjectsAutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Exercise1 {
    private WebDriver driver;

    public Exercise1(WebDriver driver){
        this.driver = driver;
    }

    public void TickAllCheckBoxes(){
       // driver.findElement(By.xpath("//p[4]/input[1]")).click();
       // driver.findElement(By.xpath("//p[4]/input[2]")).click();
       // driver.findElement(By.xpath("//p[4]/input[3]")).click();
       // driver.findElement(By.xpath("//p[4]/input[4]")).click();


        // var is flexible - java compiler will resolve this into the correct object type it needs to be
        //List<WebElement> elements1 = driver.findElements(By.xpath("//input[@name='CB_1']"));

        var elements = driver.findElements(By.xpath("//input[@name='CB_1']"));
        //contains example

        //-//input[@name='CB_1'][not(@disabled)]
        //-//input[@name='CB_1']

        //for each loop we are not in control of the iterator, therefore we can only go through until the end
        int i = 0;
        for (var ele:elements) {
            if (ele.isEnabled()) {
                ele.click();
            }
            i++;
        }

        //for loop gives more control over i and we can choose how many times we iterate it
        for(int j = 0; j < elements.size(); j++){
            var ele = elements.get(j);
            if (ele.isEnabled()) {
                ele.click();
            }
        }
        //while loop can be more complicated
        int k = 0;
        while ( k < elements.size()){
            var ele = elements.get(k);
            if (ele.isEnabled()) {
                ele.click();
            }
            k++;
        }
        //while loops has the condition at the start
        int x = 0;
        boolean isComplete = true;
        while (!isComplete){
            var ele = elements.get(x);
            if (ele.isEnabled()) {
                ele.click();
            }
            x++;
            if (x >= elements.size()){
                isComplete = true;
            }
        }

        // do while has the condition at the end
        int y = 0;
        boolean isFinished = true;

        do{
            var ele = elements.get(y);
            if (ele.isEnabled()) {
                ele.click();
            }
            y++;
            if (y >= elements.size()){
                isFinished = true;
            }

        } while (!isFinished);

        // i,j,k - use these as iterator values if you have multiple loops in the same block of code
    }
}
