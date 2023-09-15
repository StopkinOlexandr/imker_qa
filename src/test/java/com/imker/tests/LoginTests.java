package com.imker.tests;

import com.imker.model.User;
import lombok.Builder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Builder
public class LoginTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test(priority = 1)
  public void loginAdminPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isSignOutButtonPresent());
  }

  @Test(priority = 2)
  public void loginMemberPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("member@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isSignOutButtonPresent());
  }

  @Test(priority = 3)
  public void loginUserPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("user@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isSignOutButtonPresent());
  }
  @Test(priority = 4)
  public void loginNegativeWithoutPasswordTest() {
//    if (!app.getUser().isLoginLinkPresent()) {
//      app.getUser().clickOnSignOutButton();
//    }
    app.getUser().ReloadPage();
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .build());
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(
        app.getUser().isPasswordNeeded());
  }

  @Test(priority = 5)
  public void loginNegativeWithoutEmailAndPasswordTest() {
    app.getUser().ReloadPage();
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isEmailNeeded());
  }

  @Test(priority = 6)
  public void loginNegativeWrongEmail() {
    app.getUser().ReloadPage();
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss1@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isToastPresent());
  }

  @Test(priority = 7)
  public void loginNegativeWrongPassword() {
    app.getUser().ReloadPage();
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("!Boss1234")
        .build());
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isToastPresent());
  }

  @Test(priority = 8)
  public void loginNegativeSqlInEmail() {
    app.getUser().ReloadPage();
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("SELECT * from ACCOUNT")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isEmailNotCorrect());
  }

  @Test(priority = 9)
  public void loginNegativeSqlInPassword() {
    app.getUser().ReloadPage();
    app.getUser().clickOnLoginLink();
    app.getUser().fillLoginForm(User.builder()
        .email("boss@gmail.com")
        .password("SELECT * from ACCOUNT 1")
        .build());
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getUser().isToastPresent());
  }
}