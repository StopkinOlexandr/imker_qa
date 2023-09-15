package com.imker.tests;

import lombok.Builder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Builder
public class EventsPageTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void loadEventsPagePositiveTest() {
    app.getEventsPage().clickOnEventsLink();
    Assert.assertTrue(app.getEventsPage().isEventsBannerPresent());
  }

}
