package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppointmentConfirmationPage {
    WebDriver driver;
    private By facility=By.id("facility");
    private By pageHeader=By.xpath("//div[@class=\"row\"]/div[1]/h2");
    private By hospitalReadmission=By.id("hospital_readmission");
    private By program=By.id("program");
    private By visitDate=By.id("visit_date");
    private By comment=By.id("comment");
    private By goBacktoHomePage=By.linkText("Go to Homepage");



    public AppointmentConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String GetPageHeader()
    {
        return driver.findElement(pageHeader).getText();
    }
    public String getFacilityValue()
    {
        return driver.findElement(facility).getText();

    }
    public String getReadmissionValue()
    {
        return driver.findElement(hospitalReadmission).getText();

    }
    public String getProgramValue()
    {
      //  return findElementByID("").getText();
        return driver.findElement(program).getText();
    }
    public String getVisitDate()
    {
        return driver.findElement(visitDate).getText();
    }
    public String getComments()
    {
        return driver.findElement(comment).getText();
    }
    public HomePage gobacktoHomePage()
    {
        driver.findElement(goBacktoHomePage).click();
        return new HomePage(driver);
    }
}
