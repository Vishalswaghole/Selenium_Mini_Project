package com.qa.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.utility.ExcelUtility;

public class Tc_Alibaba extends Test_Base {
	@Test(dataProvider = "getData")
	public void searchItem(String SearchItems) throws InterruptedException {
		alibaba.getsearchbox().clear();
		Thread.sleep(1000);
		alibaba.getsearchbox().sendKeys(SearchItems);
		alibaba.getclicksearchbox().click();

	    Thread.sleep(1000);

		List<WebElement> itemslist = alibaba.Getgetlistitems();
		Reporter.log("Total number od items searched:" + itemslist.size());
		Assert.assertTrue(itemslist.size() <= 20);
		for (WebElement webElement : itemslist) {
			Reporter.log(webElement.getText());
		}

		String Title = driver.getTitle();
		if (Title.contains(SearchItems)) {
			Reporter.log("The item is searched", true);
			Assert.assertTrue(true);
		} else {
			try {
				captureScreenshot(driver, "searchItem");
			} catch (IOException e) {

				e.printStackTrace();
			}
			Reporter.log("The item is not  searched", true);
			Assert.assertTrue(false);
		}

	}

	@DataProvider
	public String[][] getData() throws IOException {
		String xFile = "C:\\Users\\DELL\\eclipse-Testingvisshworkspace\\Selenium_Mini_Project\\src\\test\\java\\com\\qa\\testdata\\Alibaba1.xlsx";
		String xSheet = "Sheet1";
		int rowCount = ExcelUtility.getRowConut(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;
	}

}
