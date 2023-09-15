package com.imker.tests;

import lombok.Builder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Builder
public class ContactPageTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void loadBlogPagePositiveTest() {
    app.getContactPage().clickOnContactLink();
    Assert.assertTrue(app.getContactPage().isContactBannerPresent());
  }

  @Test
  public void SendRequestPositiveTest() {
    app.getContactPage().clickOnContactLink();
    Assert.assertTrue(app.getContactPage().isContactBannerPresent());
  }

}
