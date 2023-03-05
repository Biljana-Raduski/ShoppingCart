import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    By registerLink = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    By selectorGender = By.xpath("//*[@id=\"gender-male\"]");
    By firstNameField = By.xpath("//*[@id=\"FirstName\"]");
    By lastNameField = By.xpath("//*[@id=\"LastName\"]");
    By emailField = By.xpath("//*[@id=\"Email\"]");
    By passwordField = By.xpath("//*[@id=\"Password\"]");
    By confirmPasswordField = By.xpath("//*[@id=\"ConfirmPassword\"]");
    By registerButton = By.xpath("//*[@id=\"register-button\"]");
    By welcomepageText = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]");
    By continueButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input");


    @Test
    public void registationUserTest(){
        String email = Utils.generateRandomEmail();
        System.out.println("Email: " + email);

        clickonElement(registerLink);
        clickonElement(selectorGender);
        typeIn(firstNameField, "Misa");
        typeIn(lastNameField, "Misic");
        typeIn(emailField, email);
        typeIn(passwordField,"misa123456");
        typeIn(confirmPasswordField, "misa123456");
        clickonElement(registerButton);

        String actualText = getTextFromElement(welcomepageText);
        String expectedText = "Your registration completed";

        softAssert.assertEquals(actualText, expectedText);

        softAssert.assertTrue(isElementVisible(continueButton),"Continue button is not present on page!");

        System.out.println("Izvrsene su sve asercije!");
        softAssert.assertAll();











    }

























}

