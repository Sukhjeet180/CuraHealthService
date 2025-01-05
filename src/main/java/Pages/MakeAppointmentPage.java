package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class MakeAppointmentPage {
    private WebDriver driver;
    private WebElement facilityDropDown;
    private By pageHeader=By.xpath("//div[@class=\"row\"]/div[1]/h2");
    private By facility=By.id("combo_facility");
    private By hospitalReadmision=By.id("chk_hospotal_readmission");
    private By program=By.id("radio_program_medicaid");
    private By bookAppointmentButton=By.id("btn-book-appointment");
    private By visitDate=By.id("txt_visit_date");
    private By comments=By.id("txt_comment");


    public MakeAppointmentPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void switchtoFrameAndAccept()
    {
        driver.switchTo().alert().accept();
    }
    public String GetPageHeader()
    {
        return driver.findElement(pageHeader).getText();
    }

    public WebElement findElementByID(String id)
    {
        return driver.findElement(By.id(id));
    }
    public void selectFacilityDropDownValue(String text)
    {
       // facilityDropDown=driver.findElement(By.id("combo_facility"));
        facilityDropDown=driver.findElement(facility);
        Select dropdownselect=new Select(facilityDropDown);
        dropdownselect.selectByVisibleText(text);
    }

    public void selectReadmissionCheckbox()
    {
        driver.findElement(hospitalReadmision).click();

    }

    public void selectHealthCareProgramRadioButton()
    {
        driver.findElement(program).click();

    }
   public AppointmentConfirmationPage bookAppointment()
   {
       driver.findElement(bookAppointmentButton).click();
       return  new AppointmentConfirmationPage(driver);
   }

    public void enterDate(String date)
    {
        driver.findElement(visitDate).sendKeys(date);

    }
    public void addComment(String text)
    {
        driver.findElement(comments).sendKeys(text);
    }

}
