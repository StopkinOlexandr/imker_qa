package com.imker.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

  @Test
  public void openHomePageTest() {
    Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
  }

  @Test
  public void HomePageFullLoadedTest() {
    Assert.assertTrue(app.getHomePage().isAllHomeComponentsPresents());
  }
}