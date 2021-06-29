package com.qa.test;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.Alibaba_Pages;

public class Test_Base {
	WebDriver driver;
	Alibaba_Pages alibaba;

	@Parameters({ "Browser", "Url" })
	@BeforeClass
	public void SetUp(String Browser, String Url) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			alibaba = new Alibaba_Pages(driver);
			driver.get(Url);

		} else if (Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\DELL\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			alibaba = new Alibaba_Pages(driver);
			driver.get(Url);
		}
	}

	@AfterClass
	public void TearDown() {
		driver.close();
	}

	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File Source = screenshot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir") + "/Screenshots/" + tname + ".png";
		FileUtils.copyFile(Source, new File(Dest));

	}
}

//ChromeOptions opt=new ChromeOptions();
//opt.addArguments("---disable-notification");
//driver=new ChromeDriver(opt);