package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private  WebDriver driver;
    private By makeAppointmentButton=By.id("btn-make-appointment");
//This is test comment

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public LoginPage clickMakeAppointmentButton()
    {
        driver.findElement(makeAppointmentButton).click();
        return new LoginPage(driver);
    }
}
