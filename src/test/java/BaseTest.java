import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BaseTest {


    WebDriver driver;
    protected SoftAssert softAssert;
    WebDriverWait wait;
    @BeforeMethod(alwaysRun = true)
    public  void setup() throws InterruptedException{
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
    }

@AfterMethod
    public void terDown(){
        driver.quit();
}

protected WebElement getElement (By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return  element;
}

protected void  typeIn (By locator, String text){
        getElement(locator).sendKeys(text);
}
protected void  clickonElement (By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
}
protected String getTextFromElement (By locator){
        return  getElement(locator).getText();
}
protected String getColorFromElement (By locator, String cssValue){
        return getElement(locator).getCssValue(cssValue);
}

protected boolean isElementVisible (By locator){
    List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    if (!list.isEmpty() && (list.get(0) !=null)){
        return  list.get(0).isDisplayed();
    }
        return false;
    }
}




