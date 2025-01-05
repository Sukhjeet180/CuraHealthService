package BaseTests;

import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MyTestWatcher.class)
public class HomePageTests extends BaseTests{


    private LoginPage loginPage;
    private String loginPageHeader;
    @Test
    public void MakeAppointmentButtonClickTest()
    {
       // homePage.findElementByID();
        System.out.println("Inside MakeAppointmentButtonClickTest");
      loginPage=homePage.clickMakeAppointmentButton();
      loginPageHeader=loginPage.GetPageHeader();
      assertEquals("Login",loginPageHeader,"The Login Page Header do not match");

    }
}
