package com.imker.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GalleryPageHelper extends BaseHelper{

  public GalleryPageHelper (WebDriver driver) {super(driver);}

  public void clickOnGalleryLink() {
    click(By.xpath("//a[text()='Galerie']"));
  }

  public boolean isGalleryBannerPresent() {
    return isElementPresent(By.xpath("//h2[text()='Unsere Galerie']"));
  }

  public void clickOnImageLink() {
    click(By.xpath("//img[@id='23']"));
  }
}
