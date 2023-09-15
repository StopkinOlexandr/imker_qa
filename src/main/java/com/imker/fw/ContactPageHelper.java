package com.imker.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactPageHelper extends BaseHelper{

  public ContactPageHelper (WebDriver driver) {super(driver);}


  public void clickOnContactLink() {
    click(By.xpath("//a[text()='Kontakt']"));
  }

  public boolean isContactBannerPresent() {
    return isElementPresent(By.xpath("//h2[text()='Kontakt ']"));
  }



}
