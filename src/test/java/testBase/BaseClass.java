package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;
import utilities.ScreenRecorderUtil;

public class BaseClass {
public static WebDriver driver;
Faker fakedata;
public Properties properties;
public Logger logger;
public static JavascriptExecutor js;
public ChromeOptions options;
	@BeforeClass
	@Parameters("browser")
	public void browserSetUp(String browser) throws IOException
	{
		try {
            ScreenRecorderUtil.startRecord("browserSetUp"); // Ensure this method exists
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");
		properties= new Properties();
		properties.load(fis);
		
		logger = (Logger) LogManager.getLogger(this.getClass());
		switch(browser.toLowerCase())
		{
		case "chrome": 
		options= new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		//options.addArguments("--headless=new");
		driver = new ChromeDriver(options);break;
		case "edge": driver = new EdgeDriver();break;
		case "firefox" : driver = new FirefoxDriver();break;
		default: System.out.println("Invalid Browser");return;
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.get(properties.getProperty("appURL"));
		//driver.get(properties.getProperty("appURL2"));
		js = (JavascriptExecutor) driver;
		
	}
	 public void tearDown() {
	        // Stop recording
	        try {
	            ScreenRecorderUtil.stopRecord();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        // Close the driver
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
public String captureScreen(String tname) {
		
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshot\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
	


	

}
