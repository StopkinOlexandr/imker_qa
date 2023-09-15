package com.imker.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPageHelper extends BaseHelper {

  public AdminPageHelper(WebDriver driver) {
    super(driver);
  }


  public void clickOnAdminLink() {
    click(By.xpath("//a[text()='Admin']"));
  }

  public boolean isAdminMenuBlogPresent() {
    return isElementPresent(By.xpath("//button[text()='BLOG']"));
  }

  public void clickOnBlogAdminPage() {
    click(By.xpath("//button[text()='BLOG']"));
  }

  public boolean isAdminMenuPostsPresent() {
    return isElementPresent(By.xpath("//h4[contains(text(), 'Total count of posts:')]"));
  }

  public void clickOnEventsAdminPage() {
    click(By.xpath("//button[text()='VERANSTALTUNGEN']"));
  }

  public boolean isAdminMenuEventsPresent() {
    return isElementPresent(By.xpath("//h4[contains(text(), 'Total count of events :')]"));
  }

  public void clickOnContactUsAdminPage() {
    click(By.xpath("//button[text()='Kontaktieren Sie uns']"));
  }

  public boolean isAdminMenuContactUsPresent() {
    return isElementPresent(By.xpath("//h2[contains(text(), 'Requests received from users:')]"));
  }

  public void clickOnAboutUsAdminPage() {
    click(By.xpath("//button[contains(text(), 'ber uns')]"));
  }

  public boolean isAdminMenuAboutUsPresent() {
    return isElementPresent(By.xpath("//button[text()='Alle Mitglieder']"));
  }

  public void clickOnGalleryAdminPage() {
    click(By.xpath("//button[text()='Gallery']"));
  }

  public boolean isAdminMenuGalleryPresent() {
    return isElementPresent(By.xpath("//p[contains(text(), 'Total files in gallery:')]"));
  }

  public void clickOnSliderAdminPage() {
    click(By.xpath("//button[text()='Sliders']"));
  }

  public boolean isAdminMenuSliderPresent() {
    return isElementPresent(By.xpath("//p[contains(text(), 'Total slider files:')]"));
  }

  public void clickOnUsersAdminPage() {
    click(By.xpath("//button[text()='Users']"));
  }

  public boolean isAdminMenuUsersPresent() {
    return isElementPresent(By.xpath("//p[contains(text(), 'Total count of users:')]"));
  }

  public void clickOnFilesAdminPage() {
    click(By.xpath("//button[text()='Files Upload']"));
  }

  public boolean isAdminMenuFilesPresent() {
    return isElementPresent(By.xpath("//p[contains(text(), 'Total files:')]"));
  }
}
