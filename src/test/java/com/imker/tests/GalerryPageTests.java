package com.imker.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GalerryPageTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void loadGalleryPagePositiveTest() {
    app.getGalleryPage().clickOnGalleryLink();
    Assert.assertTrue(app.getGalleryPage().isGalleryBannerPresent());
  }

  @Test
  public void openImageTest() {
    app.getGalleryPage().clickOnGalleryLink();
    app.getGalleryPage().clickOnImageLink();
    Assert.assertTrue(app.getGalleryPage().isImagePresent());
    app.getGalleryPage().clickOutsideImageLink();
  }
}
