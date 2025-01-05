package BaseTests;

import Pages.LoginPage;
import Pages.MakeAppointmentPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyTestWatcher.class)
public class LoginPageTests extends BaseTests{
    private LoginPage loginPage;
    private MakeAppointmentPage makeAppointmentPage;
    private String pageHeader;
    private String errorMessage;

    @ParameterizedTest
    @CsvSource(value = {"John Doe, ThisIsNotAPassword"})
    public void LoginSuccessTest(String username,String password)
    {

        loginPage=homePage.clickMakeAppointmentButton();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        makeAppointmentPage=loginPage.clickLoginButton();
        pageHeader=makeAppointmentPage.GetPageHeader();
        assertEquals("Make Appointment",pageHeader,"PageHeader do not match");
    }

    @ParameterizedTest
    @CsvSource(value = {"Test, ThisIsNotAPassword"})
    public void IncorrectUsernameLoginTest(String username,String password)
    {

        loginPage=homePage.clickMakeAppointmentButton();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        makeAppointmentPage=loginPage.clickLoginButton();
        if (Objects.isNull(makeAppointmentPage))
        {
            System.out.println("Inside If block");
          errorMessage= loginPage.checkErrorMessage();
        }

       // pageHeader=makeAppointmentPage.GetPageHeader();
        System.out.println("Error Message displayed: "+errorMessage);
        assertTrue(errorMessage.contains("Login failed"));
    }

    @ParameterizedTest
    @CsvSource(value = {"John Doe, Password"})
    public void IncorrectPasswordLoginTest(String username,String password)
    {

        loginPage=homePage.clickMakeAppointmentButton();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        makeAppointmentPage=loginPage.clickLoginButton();
        if (Objects.isNull(makeAppointmentPage))
        {
            System.out.println("Inside If block");
            errorMessage= loginPage.checkErrorMessage();
        }

        // pageHeader=makeAppointmentPage.GetPageHeader();
        System.out.println("Error Message displayed: "+errorMessage);
        assertTrue(errorMessage.contains("Login failed"));
    }

}
