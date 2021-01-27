import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;
import pageobjectsAutomationExercise.*;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class AutomationTrainingTests {

    private WebDriver driver;

    @BeforeEach
    public void NecessaryCode(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\J168XFO\\Downloads\\chromedriver_win32_87\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("C:/Users/J168XFO/Downloads/Practice%20Automation%20Controls/AutomationTraining1.html");
    }

    @Test
    public void Exercise1(){
       Exercise1 exercise1 = new Exercise1(driver);
       exercise1.TickAllCheckBoxes();
    }
    @Test
    public void Exercise2(){
        Exercise2 exercise2 = new Exercise2(driver);
        //exercise2.replaceText();
        exercise2.UpdateMeLoop();
    }
    @Test
    public void Exercise4(){
        Exercise4 exercise4 = new Exercise4(driver);
        exercise4.byIndexChoice();
    }
    @Test
    public void Exercise5(){
        Exercise5 exercise5 = new Exercise5(driver);
        exercise5.compareExpressionRefined();
        exercise5.compareExpression();
    }
    @Test
    public void Exercise6(){
        Exercise6 exercise6 = new Exercise6(driver);
        exercise6.PushTheButton();
    }
    @Test
    public void Exercise7(){
        Exercise7 exercise7 = new Exercise7(driver);
        exercise7.YesCounter();
        exercise7.GreenYes();
    }
    @Test
    public void Exercise8() throws FileNotFoundException {
        Exercise8 exercise8 = new Exercise8(driver);
        exercise8.ReadTxt();
    }
    @Test
    public void Exercise9() throws InterruptedException {
        Exercise9 exercise9 = new Exercise9(driver);
        //exercise9.MouseMovement();
        //exercise9.enhancedMouseMovement();
        exercise9.enhancedJavaScript();
    }
    @Test
    public void Exercise10() throws ParserConfigurationException, IOException, SAXException {
        Exercise10 exercise10 = new Exercise10(driver);
        exercise10.ParseFileExercise();
    }

}
