package BaseTests;

import Pages.AppointmentConfirmationPage;
import Pages.LoginPage;
import Pages.MakeAppointmentPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MyTestWatcher.class)
public class MakeAppointmentPageTests extends BaseTests {

    private LoginPage loginPage;
    private MakeAppointmentPage makeAppointmentPage;
    private AppointmentConfirmationPage appointmentConfirmationPage;
    private String pageHeader;

    @ParameterizedTest
    @CsvSource(value = {"John Doe, ThisIsNotAPassword"})
    public void makeAppointmentPositiveTest(String username, String password) {
        loginPage = homePage.clickMakeAppointmentButton();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        makeAppointmentPage = loginPage.clickLoginButton();
        pageHeader = makeAppointmentPage.GetPageHeader();
        // assertEquals("Make Appointment",pageHeader,"PageHeader do not match");
        makeAppointmentPage.selectFacilityDropDownValue(" Hongkong CURA Healthcare Center");
        makeAppointmentPage.selectReadmissionCheckbox();
        makeAppointmentPage.selectHealthCareProgramRadioButton();
        makeAppointmentPage.enterDate( "30/12/2024");
        makeAppointmentPage.addComment( "This is a test comment");
        appointmentConfirmationPage = makeAppointmentPage.bookAppointment();
        pageHeader = appointmentConfirmationPage.GetPageHeader();
        assertEquals("Appointment Confirmation", pageHeader, "Page Header do not match");
    }

}