package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By pageHeader=By.xpath("//*[@id=\"login\"]/div[@class=\"container\"]/div[@class=\"row\"]/div[1]/h2");
    private By username=By.id("txt-username");
    private By password=By.id("txt-password");
    private By errorMessage=By.cssSelector("p.lead.text-danger");
    private By loginButton=By.id("btn-login");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebElement findElementByID(String id)
    {
        return driver.findElement(By.id(id));
    }

    public String GetPageHeader()
    {
       return driver.findElement(pageHeader).getText();
    }

    public void enterUserName(String value)
    {
        driver.findElement(username).sendKeys(value);

    }

    public void enterPassword(String value)
    {
        driver.findElement(password).sendKeys(value);
    }
    public boolean isErrorMessagePresent()
    {
        try
        {
            driver.findElement(errorMessage);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
    public MakeAppointmentPage clickLoginButton()
    {
        driver.findElement(loginButton).click();
        if(isErrorMessagePresent())
        {
            return null;
        }
        else {
            return new MakeAppointmentPage(driver);
        }

    }

    public String checkErrorMessage()
    {
        return driver.findElement(errorMessage).getText();
    }

}
