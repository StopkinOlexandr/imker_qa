package com.imker.fw;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogPageHelper extends BaseHelper {

  public BlogPageHelper(WebDriver driver) {
    super(driver);
  }


  public void clickOnBlogLink() {
    click(By.xpath("//a[text()='Blog']"));
  }

  public boolean isBlogBannerPresent() {
    return isElementPresent(By.xpath("//h2[text()='BLOG']"));

  }

//  public void clickOnReadMoreLink() { //Mehr lesen
//    new WebDriverWait(driver, Duration.ofSeconds(15))
//        .ignoring(StaleElementReferenceException.class)
//        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='HONIGSORTEN']")));
//    click(By.xpath(("//a[normalize-space()='HONIGSORTEN']")));
//
////    click(By.xpath(("//a[normalize-space()='HONIGSORTEN']")));
//  }
}
