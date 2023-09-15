package com.imker.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUsPageHelper extends BaseHelper{

  public AboutUsPageHelper (WebDriver driver) {super(driver);}

  public void clickOnAboutUsLink() {
    click(By.xpath("//a[@id='aboutUsHeader']"));
  }

  public boolean isAboutUsBannerPresent() {
    return isElementPresent(By.xpath("//div[contains(@class, 'about_main')]/div/h2[contains(text(), 'uns')]"));
  }
}
