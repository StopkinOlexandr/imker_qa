package com.imker.fw;

import com.imker.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{


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

  public void clickOnLoginLink() {
    click(By.xpath("//button[text()='Login']"));
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
}