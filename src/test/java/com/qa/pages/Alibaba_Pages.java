package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alibaba_Pages
{
   WebDriver driver;
   @FindBy(xpath="//input[@class='ui-searchbar-keyword']")
   WebElement searchbox;
   public WebElement getsearchbox()
   {
	   return searchbox;
   }
   @FindBy(className="ui-searchbar-button-icon")
   WebElement clicksearchbox;
   public WebElement getclicksearchbox()
   {
	   return clicksearchbox;
   }
   @FindAll(@FindBy(className="cpv-refine-filter-item__wrapper"))
   List<WebElement> getlist;
   
  public  List<WebElement> Getgetlistitems()
   {
	   return getlist;
   }
  @FindAll(@FindBy(className="ui-footer-col"))
  List<WebElement> footerlinks;
  public List<WebElement> getfooterlinks()
  {
	  return footerlinks;
  }

   
   public Alibaba_Pages(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
}
