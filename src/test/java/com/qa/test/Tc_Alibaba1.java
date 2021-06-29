package com.qa.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Tc_Alibaba1 extends Test_Base

{
	@Test

	public void footerlink() {
		List<WebElement> footerslink = alibaba.getfooterlinks();
		if (footerslink.size() > 1) {
			for (WebElement link : footerslink) {
				Reporter.log(link.getText(), true);
			}
		} else {
			Reporter.log("Incorrect no of footer links:", true);
		}

	}
}
