import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends  BaseTest{

    By loginFieldButton = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    By emailField = By.xpath("//*[@id=\"Email\"]");
    By passwordField = By.xpath("//*[@id=\"Password\"]");
    By loginButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input");
    By welcomeloginLink = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    By logoutLink = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");


    @Test
    public void loginUserTest(){
        String email = Utils.generateRandomEmail();
        System.out.println("Email: " + email);

        clickonElement(loginFieldButton);
        typeIn(emailField, email);
        typeIn(passwordField, "misa123456");
        clickonElement(loginButton);


        softAssert.assertTrue(isElementVisible(welcomeloginLink),"Neuspelo logovanje");
        softAssert.assertTrue(isElementVisible(logoutLink),"Logout dugme nije vidljivo");

        System.out.println("Izvrsene su sve asercije!");
        softAssert.assertAll();




    }







}
