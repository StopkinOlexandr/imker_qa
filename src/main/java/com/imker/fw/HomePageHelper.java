package com.imker.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

  public HomePageHelper(WebDriver driver) {
    super(driver);
  }

  public boolean isHomeComponentPresent() {
    return isElementPresent(By.xpath("//a[text()='Blog']"));
  }

  public boolean isHomeComponentBlogPresent() {
    return isElementPresent(By.xpath("//a[text()='Blog']"));
  }

  public boolean isHomeComponentEventsPresent() { //VERANSTALTUNGEN
    return isElementPresent(By.xpath("//a[text()='Veranstaltungen']"));
  }

  public boolean isHomeComponentAboutUsPresent() { //ÜBER UNS
    return isElementPresent(By.xpath("//a[@id='aboutUsHeader']"));
  }

  public boolean isHomeComponentGalleryPresent() { //GALERIE
    return isElementPresent(By.xpath("//a[text()='Galerie']"));
  }

  public boolean isHomeComponentContactPresent() { //KONTAKT
    return isElementPresent(By.xpath("//a[text()='Kontakt']"));
  }

  public boolean isHomeComponentHoneySortsPresent() { //HONIGSORTEN
    return isElementPresent(By.xpath("//p[text()='Honig aus dem Wald']")) &&
        isElementPresent(By.xpath("//p[text()='Gesunder Honig']")) &&
        isElementPresent(By.xpath("//p[text()='Organischer Honig']"));
  }

  public boolean isHomeComponentExpertsPresent() { //UNSER EXPERTENTEAM
    return isElementPresent(By.xpath("//p[text()='1 Vorsitzender']")) &&
        isElementPresent(By.xpath("//p[text()='2 Vorsitzender']")) &&
        isElementPresent(By.xpath("//p[text()='Kassenwartin']")) &&
//        isElementPresent(By.xpath("//p[text()='Schriftführerin']")) &&
        isElementPresent(By.xpath("//p[text()='Wanderwart']"));
  }

  public boolean isHomeComponentFooterPresent() { //UNSER EXPERTENTEAM
    return isElementPresent(By.xpath("//h3[text()='Kontakte']")) &&
        isElementPresent(By.xpath("//h3[text()='VERANSTALTUNGEN']"));// &&
//        isElementPresent(By.xpath("//h3[text()='Über uns']"));
  }

  public boolean isHomeComponentPostsPresents() {
    return isElementPresent(By.xpath("//div/div/div/div[@class='container']"));
  }

  public boolean isAllHomeComponentsPresents() {
    return isHomeComponentBlogPresent() &&
        isHomeComponentEventsPresent() &&
        isHomeComponentAboutUsPresent() &&
        isHomeComponentGalleryPresent() &&
        isHomeComponentContactPresent() &&
        isHomeComponentHoneySortsPresent() &&
        isHomeComponentExpertsPresent() &&
        isHomeComponentFooterPresent() &&
        isHomeComponentPostsPresents();
  }
}
