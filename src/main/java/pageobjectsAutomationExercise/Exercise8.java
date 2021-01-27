package pageobjectsAutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise8 {
   private File file;
   private WebDriver driver;

    public Exercise8(WebDriver driver) { this.driver = driver; }

    public void ReadTxt()throws FileNotFoundException {
        file = new File("\\Users\\J168XFO\\Documents\\Temp\\AutomationTraining1.html");
        Scanner scan = new Scanner(file);
        
        String match = "ABC123DEF789";

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println(line);
            if(line.contains(match)){
                System.out.println("Complete");
                driver.findElement(By.xpath("//p[32]/input")).sendKeys(match);
                break;
            }
        }

    }
}
