package pageobjectsAutomationExercise;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise9 {
    private WebDriver driver;


    public Exercise9(WebDriver driver){ this.driver = driver; }

    public void MouseMovement() {
        driver.findElement(By.xpath("//input[@value='Begin Exercise']")).click();

        driver.manage().window().maximize();

        WebElement branchNumber = driver.findElement(By.xpath("//input[@name='BranchNumber']"));
        WebElement subLinkNumber = driver.findElement(By.xpath("//input[@name='LinkNumber']"));
        WebElement rollOverMenu = driver.findElement(By.xpath("//div[@id='mainMenu']"));

        int branchMenuNumber = Integer.parseInt(branchNumber.getAttribute("value"));
        int subMenuNumber = Integer.parseInt(subLinkNumber.getAttribute("value"));
        System.out.println("This is the sub menu number" + subMenuNumber +"This is the branch number"+branchMenuNumber);
        //get the roll over menu into view with java script execution
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rollOverMenu);

         Actions actions = new Actions(driver);
         actions.moveToElement(rollOverMenu).build().perform();

         // Move to branch
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement branchElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("SubMenu" + branchMenuNumber)));
         Actions actions1 = new Actions(driver);
         actions1.moveToElement(rollOverMenu).moveToElement(branchElement).build().perform();

        // An expectation for checking that all elements present on the web page that match the locator are visible
        // move to sub link
         WebElement subLinkElement = driver.findElement(By.xpath("//div[@id='SubMenu"+ branchMenuNumber +"']/a[contains(text(),'sub link "+ subMenuNumber +"')]"));
         actions.moveToElement(subLinkElement).build().perform();

        branchMenuNumber = Integer.parseInt(branchNumber.getAttribute("value"));
        subMenuNumber = Integer.parseInt(subLinkNumber.getAttribute("value"));
        System.out.println("This is the sub link number" + subMenuNumber +"This is the branch number"+branchMenuNumber);

    }
    public void enhancedMouseMovement() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Begin Exercise']")).click();

        Actions actions1 = new Actions(driver);

        WebElement branchNumber1 = driver.findElement(By.xpath("//input[@name='BranchNumber']"));
        WebElement subLinkNumber1 = driver.findElement(By.xpath("//input[@name='LinkNumber']"));
        WebElement rollOverMenu1 = driver.findElement(By.xpath("//div[@id='mainMenu']"));
        //move
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", branchNumber1);
        Thread.sleep(2000);
        actions1.moveToElement(rollOverMenu1).build().perform();

        boolean exerciseStatus = driver.findElement(By.xpath("//input[@value='NOT COMPLETE']")).isDisplayed();

        while (exerciseStatus){
            //get
            int subLinkValue = Integer.parseInt(subLinkNumber1.getAttribute("value"));
            int branchMenuNumber1 = Integer.parseInt(branchNumber1.getAttribute("value"));
            System.out.println("This is the branch number "+branchMenuNumber1 + "This is the sub link number" + subLinkValue);
            //move
            Thread.sleep(1000);
            //WebDriverWait wait = new WebDriverWait(driver, 10);
            //WebElement branchElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='SubMenu" + branchMenuNumber1 +"']")));
            WebElement branchElement = driver.findElement(By.xpath("//div[@id='SubMenu" + branchMenuNumber1 +"']"));
            Thread.sleep(1000);
            var myX = branchElement.getLocation().getX();
            var myY = branchElement.getLocation().getY();
            Actions actionsNew = new Actions(driver);
            actionsNew.moveByOffset(myX, myY).build().perform();
            //actionsNew.moveToElement(rollOverMenu1).moveToElement(branchElement).build().perform();
            //get
            WebElement subLinkElement = driver.findElement(By.xpath("//div[@id='SubMenu"+ branchMenuNumber1 +"']/a[contains(text(),'sub link "+ subLinkValue +"')]"));
            actions1.moveToElement(subLinkElement).build().perform();
            try{
                exerciseStatus = driver.findElement(By.xpath("//input[@value='COMPLETE']")).isDisplayed();
            } catch(NoSuchElementException ex) {

            }
            //check
            if(!exerciseStatus){
                System.out.println("Exercise Completed");
            }
        }
    }
    public void enhancedJavaScript() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@value='Begin Exercise']")).click();

        WebElement branchNumber1 = driver.findElement(By.xpath("//input[@name='BranchNumber']"));
        WebElement subLinkNumber1 = driver.findElement(By.xpath("//input[@name='LinkNumber']"));
        //move
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", branchNumber1);

        boolean exerciseStatus = driver.findElement(By.xpath("//input[@name='ExerciseStatus']")).getAttribute("value").equals("NOT COMPLETE");

        while (exerciseStatus){
            //get
            int subLinkValue = Integer.parseInt(subLinkNumber1.getAttribute("value"));
            int branchMenuNumber1 = Integer.parseInt(branchNumber1.getAttribute("value"));
            System.out.println("This is the branch number "+branchMenuNumber1 + "This is the sub link number" + subLinkValue);
            //move
            ((JavascriptExecutor) driver).executeScript("PrepareEvent("+branchMenuNumber1+","+subLinkValue+")");

            boolean isComplete = driver.findElement(By.xpath("//input[@name='ExerciseStatus']")).getAttribute("value").equals("COMPLETE");

            //check
            if(isComplete){
                System.out.println("Exercise Completed");
                exerciseStatus = false;
            }else{
                exerciseStatus = true;
            }
        }
    }
}


