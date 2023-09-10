package com.imker.fw;

import com.imker.model.User;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper {

  public UserHelper(WebDriver driver) {
    super(driver);
  }

  public void clickOnSignOutButton() {
    click(By.xpath("//button[@aria-label='Account settings']"));
    click(By.xpath("//li[normalize-space()='Logout']"));
  }

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.xpath("//button[normalize-space()='Login']"));
  }

  public boolean isUserNamePresent() {
    return isElementPresent(By.xpath("//span[text()='Alex Krause']"));
  }

  public void clickOnRegistrationButton() {
    click(By.xpath("//button[normalize-space()='Beitreten']"));
  }

  public void fillRegistrationForm(User user) {
    type(By.cssSelector("[placeholder='Name']"), user.getName());
    type(By.cssSelector("[placeholder='PLZ']"), user.getPlz());
    type(By.cssSelector("[placeholder='+49']"), user.getPhone());
    type(By.cssSelector("[placeholder='Email']"), user.getEmail());
    type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    type(By.cssSelector("[placeholder='Your question to restore ']"), user.getSecretQuestion());
    type(By.cssSelector("[placeholder='Your answer to restore ']"), user.getAnswerSecretQuestion());
  }

  public void fillLoginForm(User user) {
    type(By.cssSelector("[placeholder='Email']"), user.getEmail());
    type(By.cssSelector("[placeholder='Password']"), user.getPassword());
  }

  public void fillEmailForm(User user) {
    new WebDriverWait(driver, Duration.ofSeconds(5))
        .ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
    type(By.xpath("//input[@name='email']"), user.getEmail());
  }

  public void fillNewPasswordForm(User user) {
    new WebDriverWait(driver, Duration.ofSeconds(5))
        .ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
    type(By.xpath("//input[@name='password']"), user.getPassword());
  }

  public void clickOnLoginLink() {
    click(By.xpath("//button[text()='Login']"));
  }

  public void clickOnUpdatePassword() {
    click(By.xpath("//button[text()='Update Password']"));
  }

  public void clickOnUsersSecretQuestionRadioButton() {
    click(By.xpath("//input[@value='Auto?']"));
  }

  public void clickNotOnUsersSecretQuestionRadioButton() {
    click(By.xpath("//input[@value='Was ist Ihre Lieblingsblume?']"));
  }

  public void fillSecretQuestionAnswerForm(User user) {
    type(By.xpath("//input[@placeholder='answer']"), user.getAnswerSecretQuestion());
  }

  public void clickOnContinue() {
    click(By.xpath("//button[text()='Wiederherstellen']"));
  }


  public void clickSendButton() {
    click(By.xpath("//button[text()='Send']"));
  }

  public void clickOnRestorePasswordButton() {
    click(By.xpath("//button[text()='Passwort vergessen ?']"));
  }

  public void clickOnNewAccountRegister() {
    click(By.xpath("//button[text()='Neues Konto registrieren']"));
  }

  public boolean isSignOutButtonPresent() {
    return isElementPresent(By.xpath("//button[@aria-label='Account settings']"));
  }

  public void clickOnLoginButton() {
    click(By.xpath("//button[normalize-space()='Beitreten']"));
  }

  public void login() {
    clickOnLoginLink();
    fillLoginForm(User.builder()
        .email("bossgmail.com")
        .password("!Boos12345")
        .build());
    clickOnLoginButton();
  }

  public boolean isUserPasswordErrorPresent() {
    new WebDriverWait(driver, Duration.ofSeconds(5))
        .ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[text()='One digit, uppercase letter, one symbol']")));
    return isElementPresent(By.xpath("//div[text()='One digit, uppercase letter, one symbol']"));
  }
}