package com.imker.tests;

import com.imker.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RestorePasswordTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void UserRestorePasswordPositiveTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnRestorePasswordButton();
    app.getUser().fillEmailForm(User.builder()
        .email("user@gmail.com")
        .build());
    app.getUser().clickSendButton();
    app.getUser().clickOnUsersSecretQuestionRadioButton();
    app.getUser().fillSecretQuestionAnswerForm(User.builder()
        .answerSecretQuestion("Ford")
        .build());
    app.getUser().clickOnContinue();
    app.getUser().fillNewPasswordForm(User.builder()
        .password("!Boss12345")
        .build());
    app.getUser().clickOnUpdatePassword();
    Assert.assertTrue(app.getUser().isUserNamePresent());
  }

  @Test
  public void UserRestorePasswordNotExistingEmailNegativeTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnRestorePasswordButton();
    app.getUser().fillEmailForm(User.builder()
        .email("user05@gmail.com")
        .build());
    app.getUser().clickSendButton();
    Assert.assertFalse(
        app.getUser().isElementPresent(By.xpath("//button[text()='Wiederherstellen']")));
  }

  @Test
  public void UserRestorePasswordWrongSecretQuestionNegativeTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnRestorePasswordButton();
    app.getUser().fillEmailForm(User.builder()
        .email("user@gmail.com")
        .build());
    app.getUser().clickSendButton();
    app.getUser().clickNotOnUsersSecretQuestionRadioButton();
    app.getUser().fillSecretQuestionAnswerForm(User.builder()
        .answerSecretQuestion("Ford")
        .build());
    app.getUser().clickOnContinue();
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class='Toastify']")));
  }

  @Test
  public void UserRestorePasswordWrongSecretQuestionAnswerNegativeTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnRestorePasswordButton();
    app.getUser().fillEmailForm(User.builder()
        .email("user@gmail.com")
        .build());
    app.getUser().clickSendButton();
    app.getUser().clickOnUsersSecretQuestionRadioButton();
    app.getUser().fillSecretQuestionAnswerForm(User.builder()
        .answerSecretQuestion("Fiat")
        .build());
    app.getUser().clickOnContinue();
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class='Toastify']")));
  }

  @Test
  public void UserRestorePasswordNewPasswordNotAccomplishRulesNegativeTest() {
    app.getUser().clickOnLoginLink();
    app.getUser().clickOnRestorePasswordButton();
    app.getUser().fillEmailForm(User.builder()
        .email("user@gmail.com")
        .build());
    app.getUser().clickSendButton();
    app.getUser().clickOnUsersSecretQuestionRadioButton();
    app.getUser().fillSecretQuestionAnswerForm(User.builder()
        .answerSecretQuestion("Ford")
        .build());
    app.getUser().clickOnContinue();
    app.getUser().fillNewPasswordForm(User.builder()
        .password("Boss12345")
        .build());
    app.getUser().clickOnUpdatePassword();
    Assert.assertTrue(app.getUser().isUserPasswordErrorPresent());
  }
}