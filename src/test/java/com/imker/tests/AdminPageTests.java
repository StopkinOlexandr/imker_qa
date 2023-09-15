package com.imker.tests;

import com.imker.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPageTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test(priority = 1)
  public void loadAdminPagePositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();

    app.getAdminPage().clickOnAdminLink();
    Assert.assertTrue(app.getAdminPage().isAdminMenuBlogPresent());
  }

  @Test //(priority = 2)
  public void loadAdminPageBlogPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    app.getAdminPage().clickOnAdminLink();
    app.getAdminPage().clickOnBlogAdminPage();
    Assert.assertTrue(app.getAdminPage().isAdminMenuPostsPresent());
  }

  @Test(priority = 3)
  public void loadAdminPageEventsPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    app.getAdminPage().clickOnAdminLink();
    app.getAdminPage().clickOnEventsAdminPage();
    Assert.assertTrue(app.getAdminPage().isAdminMenuEventsPresent());
  }

  @Test(priority = 4)
  public void loadAdminPageContactUsPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    app.getAdminPage().clickOnAdminLink();
    app.getAdminPage().clickOnContactUsAdminPage();
    Assert.assertTrue(app.getAdminPage().isAdminMenuContactUsPresent());
  }

  @Test(priority = 5)
  public void loadAdminPageAboutUsPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    app.getAdminPage().clickOnAdminLink();
    app.getAdminPage().clickOnAboutUsAdminPage();
    Assert.assertTrue(app.getAdminPage().isAdminMenuAboutUsPresent());
  }

  @Test(priority = 6)
  public void loadAdminPageGalleryPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    app.getAdminPage().clickOnAdminLink();
    app.getAdminPage().clickOnGalleryAdminPage();
    Assert.assertTrue(app.getAdminPage().isAdminMenuGalleryPresent());
  }

  @Test(priority = 7)
  public void loadAdminPageSliderPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    app.getAdminPage().clickOnAdminLink();
    app.getAdminPage().clickOnSliderAdminPage();
    Assert.assertTrue(app.getAdminPage().isAdminMenuSliderPresent());
  }

  @Test(priority = 8)
  public void loadAdminPageUsersPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    app.getAdminPage().clickOnAdminLink();
    app.getAdminPage().clickOnUsersAdminPage();
    Assert.assertTrue(app.getAdminPage().isAdminMenuUsersPresent());
  }

  @Test(priority = 9)
  public void loadAdminPageFilesPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    app.getAdminPage().clickOnAdminLink();
    app.getAdminPage().clickOnFilesAdminPage();
    Assert.assertTrue(app.getAdminPage().isAdminMenuFilesPresent());
  }
}
