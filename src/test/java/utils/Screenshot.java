package utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Screenshot {

    public static String getBase64Screenshot(WebDriver driver, String fileName) throws IOException {
        String encodedBase64 = null;
        FileInputStream fileInputStream;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        Constants.SCREENSHOT_PATH = System.getProperty("user.dir") + "\\src\\test-output\\screenshots\\" + fileName + System.currentTimeMillis() + ".png";

        File finalDestination = new File(Constants.SCREENSHOT_PATH);
        FileUtils.copyFile(source, finalDestination);

        try {
            fileInputStream = new FileInputStream(finalDestination);
            byte[] bytes = new byte[(int) finalDestination.length()];
            fileInputStream.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return encodedBase64;
    }
}
