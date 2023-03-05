import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest{

 By categorybooks = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a");
 By book1 = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input");
 By book2 = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input");
 By shoppingcartButton = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");
 By sumTotal = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[2]/div[1]/table/tbody/tr[1]/td[2]/span/span");

 @Test
    public void cartTest(){

     clickonElement(categorybooks);
     clickonElement(book1);
     clickonElement(book2);
     clickonElement(shoppingcartButton);
     System.out.println("Iskliktao");

     String actualText = getTextFromElement(sumTotal); //ovde je pao,prethodne korake je izvrsio
     String expectedText = "34.00";
     softAssert.assertEquals(actualText, expectedText);


     System.out.println("Izvrsene su sve asercije!");
     softAssert.assertAll();


 }









}
