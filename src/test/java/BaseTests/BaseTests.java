package BaseTests;

import Pages.HomePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTests {
    public WebDriver driver;
    public HomePage homePage;
    private TakesScreenshot screenshot;
    @BeforeAll
    public void setUp()
    {
        System.out.println("Inside BaseTests Setup Method");
        driver=WebDriverManager.chromedriver().create();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        System.out.println("Tilte: "+driver.getTitle());
        homePage=new HomePage(driver);

    }

  /*  @AfterEach
    public void takeScreenShotofFailure() throws IOException {
        screenshot= (TakesScreenshot) driver;
        File source= screenshot.getScreenshotAs(OutputType.FILE);
      // SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
       //LocalDateTime date= LocalDateTime.now();

        Files.move(source.toPath(), new File("resources/screenshot/"+ Instant.now().getEpochSecond()+"test.png").toPath());
    }
*/
    @AfterAll
    public void cleanUp()
    {
        System.out.println("Inside BaseTests cleanUp Method");
        driver.quit();
    }

    public  static  void  main(String[] args)
    {
        BaseTests baseTests=new BaseTests();
        baseTests.setUp();
    }
}
