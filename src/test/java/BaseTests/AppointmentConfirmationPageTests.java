package BaseTests;

import Pages.AppointmentConfirmationPage;
import Pages.LoginPage;
import Pages.MakeAppointmentPage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MyTestWatcher.class)
public class AppointmentConfirmationPageTests extends BaseTests{
    private LoginPage loginPage;
    private MakeAppointmentPage makeAppointmentPage;
    private AppointmentConfirmationPage appointmentConfirmationPage;
    private String pageHeader;
    private String facility="Hongkong CURA Healthcare Center";
    private String visitDate="30/12/2024";
    private String comment="This is a test comment";


    @ParameterizedTest
    @CsvSource(value = {"John Doe, ThisIsNotAPassword"})

    public void makeAppointmentPositiveTest(String username, String password) {
        loginPage = homePage.clickMakeAppointmentButton();
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        makeAppointmentPage = loginPage.clickLoginButton();
        pageHeader = makeAppointmentPage.GetPageHeader();
        // assertEquals("Make Appointment",pageHeader,"PageHeader do not match");
        makeAppointmentPage.selectFacilityDropDownValue( facility);
        makeAppointmentPage.selectReadmissionCheckbox();
        makeAppointmentPage.selectHealthCareProgramRadioButton();
        makeAppointmentPage.enterDate( visitDate);
        makeAppointmentPage.addComment( comment);
        appointmentConfirmationPage = makeAppointmentPage.bookAppointment();
        pageHeader = appointmentConfirmationPage.GetPageHeader();
        assertEquals("Appointment Confirmation", pageHeader, "Page Header do not match");
        assertEquals(appointmentConfirmationPage.getFacilityValue(),facility,"Facility value do not match");
        assertEquals(appointmentConfirmationPage.getReadmissionValue(),"Yes");
        assertEquals(appointmentConfirmationPage.getProgramValue(),"Medicaid","Health Program do not match");
        assertEquals(appointmentConfirmationPage.getVisitDate(),visitDate,"Visit Date do not match");
        assertEquals(appointmentConfirmationPage.getComments(),comment,"Comment do not match");

    }
}
