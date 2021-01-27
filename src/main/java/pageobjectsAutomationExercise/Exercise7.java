package pageobjectsAutomationExercise;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class Exercise7 {
    private WebDriver driver;

    public Exercise7 (WebDriver driver){
        this.driver = driver;
    }
    //Initialized method , ie constructor

    //The first thing we did is create constructor with the same name as the class
    //Named a method the exact same thing as the class
    //Because we create the object WebDriver driver, we can then pass driver into the code
    //this refers to the privatised driver object hence it is purple coloured.

    public void YesCounter(){

        List <WebElement> rows = driver.findElements(By.xpath("//table//tr"));

        //go through a loop
        int count = 0;
        for (WebElement row:rows) {
            List<WebElement> columns = row.findElements(By.xpath("./td"));

            for (WebElement column : columns) {
                String columnText = column.getText();

                if (columnText.contains("YES")) {
                    count++;
                }
            }
        }
        Assert.assertEquals(4, count);

        String newSend = Integer.toString(count);
        driver.findElement(By.xpath("//input[@value='n']")).clear();
        driver.findElement(By.xpath("//input[@value='n']")).sendKeys(newSend);
    }

    public void GreenYes(){
        List <WebElement> rows = driver.findElements(By.xpath("//table//tr"));

        int endRow = 0;
        int endCol = 0;
        int rowCount = 0;

        for (WebElement row:rows) {
            List<WebElement> columns = row.findElements(By.xpath("./td"));
            //get all the columns that exist for the rows
            int colCount = 0;
            for (WebElement column : columns) {
                String columnText = column.getText();
                String newColour;
                try{
                   WebElement gridFont = column.findElement(By.xpath("./font"));
                   newColour = gridFont.getAttribute("color");

               }catch(NoSuchElementException ex){
                   newColour = "";
               }


                if (columnText.contains("YES")&& newColour.equals("GREEN")) {
                    endRow = rowCount;
                    endCol = colCount;
                    break;
                }
                colCount++;
            }
            rowCount++;
            if(endCol > 0){
                break;
            }
        }

        driver.findElement(By.xpath("//input[@name='Ex_6_Row']")).clear();
        driver.findElement(By.xpath("//input[@name='Ex_6_Row']")).sendKeys(Integer.toString(endRow));
        driver.findElement(By.xpath("//input[@name='Ex_6_Column']")).clear();
        driver.findElement(By.xpath("//input[@name='Ex_6_Column']")).sendKeys(Integer.toString(endCol));
    }
}
