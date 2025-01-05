package BaseTests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

public class MyTestWatcher implements TestWatcher {
    WebDriver driver;
    TakesScreenshot screenshot;
/*
    public  MyTestWatcher(WebDriver driver)
    {
        this.driver=driver;
    } */
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        System.out.println("Test Failed --------------------------------------------");
        try {
            Object object=context.getRequiredTestInstance();
           //   System.out.println("-------------------------object.getClass() :value: "+object.getClass());
          //  System.out.println("-------------------------object.getClass().getSuperclass :value: "+object.getClass().getSuperclass());
            Field field= object.getClass().getSuperclass().getField("driver");
           // System.out.println("-------------------------object.getfield() :value: "+field);
            //field.setAccessible(true);
            driver= (WebDriver) field.get(object);
            screenshot=(TakesScreenshot) driver;
            File source= screenshot.getScreenshotAs(OutputType.FILE);
            try {
               // Files.move(source.toPath(), new File("resources/screenshot/" + Instant.now().getEpochSecond() + context.getTestMethod()+"test.png").toPath());
                Files.move(source.toPath(), new File("resources/screenshot/" + Instant.now().getEpochSecond() + context.getTestMethod()+"test.png").toPath());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}
