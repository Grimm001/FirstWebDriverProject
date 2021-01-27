package pageobjectsAutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise5 {
    private WebDriver driver;

    public Exercise5(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isString3NumsOrLetters(String inputString) {
        Pattern p = Pattern.compile("^([A-Z]{3})|([0-9]{3})");
        Matcher m = p.matcher(inputString);
        Boolean b = m.matches();
        System.out.println(b);
        return b;
    }

    public void compareExpression(){
        String test1 = driver.findElement(By.xpath("//p[20]/input[1]")).getAttribute("value");
        String test2 = driver.findElement(By.xpath("//p[20]/input[2]")).getAttribute("value");
        String test3 = driver.findElement(By.xpath("//p[20]/input[3]")).getAttribute("value");
        String test4 = driver.findElement(By.xpath("//p[20]/input[4]")).getAttribute("value");
        String test5 = driver.findElement(By.xpath("//p[20]/input[5]")).getAttribute("value");
        String test6 = driver.findElement(By.xpath("//p[20]/input[6]")).getAttribute("value");
        String test7 = driver.findElement(By.xpath("//p[20]/input[7]")).getAttribute("value");

        if (isString3NumsOrLetters(test1)){
            driver.findElement(By.xpath("//p[20]/input[1]")).clear();
            driver.findElement(By.xpath("//p[20]/input[1]")).sendKeys(test1 + "MATCH");
        }
        if (isString3NumsOrLetters(test2)){
            driver.findElement(By.xpath("//p[20]/input[2]")).clear();
            driver.findElement(By.xpath("//p[20]/input[2]")).sendKeys(test1 + "MATCH");
        }
        if (isString3NumsOrLetters(test3)){
            driver.findElement(By.xpath("//p[20]/input[3]")).clear();
            driver.findElement(By.xpath("//p[20]/input[3]")).sendKeys(test1 + "MATCH");
        }
        if (isString3NumsOrLetters(test4)){
            driver.findElement(By.xpath("//p[20]/input[4]")).clear();
            driver.findElement(By.xpath("//p[20]/input[4]")).sendKeys(test1 + "MATCH");
        }
        if (isString3NumsOrLetters(test5)){
            driver.findElement(By.xpath("//p[20]/input[5]")).clear();
            driver.findElement(By.xpath("//p[20]/input[5]")).sendKeys(test1 + "MATCH");
        }
        if (isString3NumsOrLetters(test6)){
            driver.findElement(By.xpath("//p[20]/input[6]")).clear();
            driver.findElement(By.xpath("//p[20]/input[6]")).sendKeys(test1 + "MATCH");
        }
        if (isString3NumsOrLetters(test7)){
            driver.findElement(By.xpath("//p[20]/input[7]")).clear();
            driver.findElement(By.xpath("//p[20]/input[7]")).sendKeys(test1 + "MATCH");
        }

    }

    public void compareExpressionRefined(){

        for (int i = 1; i < 8; i++) {
            String test = driver.findElement(By.xpath("//p[20]/input[" + i + "]")).getAttribute("value");

            if (isString3NumsOrLetters(test)) {
                driver.findElement(By.xpath("//p[20]/input["+ i + "]")).clear();
                driver.findElement(By.xpath("//p[20]/input[" + i + "]")).sendKeys(test + "MATCH");
            }
        }
    }

}
