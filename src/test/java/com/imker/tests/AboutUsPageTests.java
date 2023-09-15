package com.imker.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AboutUsPageTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void loadAboutUsPagePositiveTest() {
    app.getAboutUsPage().clickOnAboutUsLink();
    Assert.assertTrue(app.getAboutUsPage().isAboutUsBannerPresent());
  }

}
