package com.imker.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventsPageHelper extends BaseHelper {

  public EventsPageHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnEventsLink() {
    click(By.xpath("//a[text()='Veranstaltungen']"));
  }

  public boolean isEventsBannerPresent() {
    return isElementPresent(By.xpath("//h2[text()='UNSERE VERANSTALTUNGEN']"));
  }
}
