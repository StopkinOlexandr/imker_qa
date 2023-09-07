package com.imker.tests;

import com.imker.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateAccountTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void NewUserRegistrationPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnNewAccountRegister();
    app.getUser().fillRegistrationForm(User.builder()
        .name("User03")
        .plz("12345")
        .phone("01234567890123")
        .email("user03@gmail.com")
        .password("!Boss12345")
        .secretQuestion("First car?")
        .answerSecretQuestion("Ford")
        .build());
    app.getUser().clickOnRegistrationButton();
    Assert.assertTrue(app.getUser().isLoginLinkPresent());
  }

  @Test
  public void NewUserRegistrationRequiredFieldsPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnNewAccountRegister();
    app.getUser().fillRegistrationForm(User.builder()
        .plz("12345")
        .phone("01234567890123")
        .email("user04@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnRegistrationButton();
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[text()='Sing In']")));
  }

  @Test
  public void NewUserRegistrationRequiredFieldsMistakePlzNegativeTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnNewAccountRegister();
    app.getUser().fillRegistrationForm(User.builder()
        .plz("1234")
        .phone("01234567890123")
        .email("user04@gmail.com")
        .password("!Boss12345")
        .build());
    app.getUser().clickOnRegistrationButton();
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[text()='Register']")));
  }

  @Test
  public void NewUserRegistrationRequiredFieldsMistakeEmailNegativeTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnNewAccountRegister();
    app.getUser().fillRegistrationForm(User.builder()
        .plz("12345")
        .phone("01234567")
        .email("user04gmail.com")
        .password("!Boss12345")
        .build());
   Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='Invalid email']")));
  }

  @Test
  public void NewUserRegistrationRequiredFieldsMistakePasswordNegativeTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnNewAccountRegister();
    app.getUser().fillRegistrationForm(User.builder()
        .plz("12345")
        .phone("01234567")
        .email("user04@gmail.com")
        .password("Boss12345")
        .build());
    app.getUser().clickOnRegistrationButton();
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[text()='One digit, uppercase letter, one symbol']")));
  }

  @Test
  public void existedUserRegistrationNegativeTest() { //TODO change front for reaction
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnNewAccountRegister();
    app.getUser().fillRegistrationForm(User.builder()
        .name("User03")
        .plz("12345")
        .phone("01234567890123")
        .email("user03@gmail.com")
        .password("!Boss12345")
        .secretQuestion("First car?")
        .answerSecretQuestion("Ford")
        .build());
    app.getUser().clickOnRegistrationButton();
    Assert.assertFalse(app.getUser().isLoginLinkPresent());
  }

}