package com.w2e.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2e.utilities.ExcelReader;
import com.w2e.utilities.Extentmanager;

/**
 * Actually base class is used to initialize the things we want work with like
 * WebDriver - done
 * properties - done
 * Logs 
 * ExtentReports,ReportNG
 * DB 
 * Excel 
 * Mail
 * Jenkins
 * 
 * @author surendarg97
 *
 */

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fisConfig;
	public static Properties ObjectRespository = new Properties();
	public static FileInputStream fisObjectRespository;
	public static Logger log=Logger.getLogger(TestBase.class.getName());
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir") + "//src//test//resources//excel//ExcelRead.xlsx");
	public static WebDriverWait wait;
	public ExtentReports report=Extentmanager.getInstance();
	public static ExtentTest test;

	@BeforeSuite
	public void setUp() {
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		

		if (driver == null) {

			try {
				fisConfig = new FileInputStream(
						System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");
			} catch (FileNotFoundException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				config.load(fisConfig);
				log.info("Config file loaded!!");
			} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }

			}
			try {
				fisObjectRespository = new FileInputStream(System.getProperty("user.dir")
						+ "//src//test//resources//properties//ObjectRespository.properties");
			} catch (FileNotFoundException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				ObjectRespository.load(fisObjectRespository);
				log.debug("ObjectRespository file loaded!!");
			} catch (IOException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//src//test//resources//drivers//chromedriver.exe");
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "//src//test//resources//drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "//src//test//resources//drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

		}

		driver.get(config.getProperty("url"));
		log.info("Navigated to respective url!!");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWaitTimeInSeconds")),
				TimeUnit.SECONDS);
		wait= new WebDriverWait(driver,5);

	}
	
	
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e) {
			return false;
			
		}
	}
	
	public void click(String locator) {
		
		driver.findElement(By.cssSelector(ObjectRespository.getProperty(locator))).click();
		test.log(LogStatus.INFO, "Clicking on: "+locator);
	}
	
	public void typing(String locator,String value) {
		
		driver.findElement(By.cssSelector(ObjectRespository.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "Typing in: "+locator+" entered value as "+ value);
	}
	

	@AfterSuite
	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}
		
		log.info("Execution is completed!!");

	}
}
