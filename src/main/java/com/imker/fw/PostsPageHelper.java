package com.imker.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostsPageHelper extends BaseHelper {

  public PostsPageHelper(WebDriver driver) { super(driver); }

  public boolean isPostsPresent() {
    return isElementPresent(By.xpath("//a[text()='POSTS']"));
  }
}
