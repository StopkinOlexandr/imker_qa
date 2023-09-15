package com.imker.fw;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GalleryPageHelper extends BaseHelper {

  public GalleryPageHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnGalleryLink() {
    click(By.xpath("//a[text()='Galerie']"));
  }

  public boolean isGalleryBannerPresent() {
    return isElementPresent(By.xpath("//h2[text()='Galerie']"));
  }

  public void clickOnImageLink() {
    jsClick(By.xpath("//img[@id='18']"));

  }

  public boolean isImagePresent() {
    return isElementPresent(By.xpath("//img[contains(@class, '_modal_container')]"));
  }

  public void clickOutsideImageLink() {

    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
    actions.moveByOffset(-500, -50).click().build().perform();
  }
}
