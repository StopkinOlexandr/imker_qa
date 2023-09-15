package com.imker.tests;

import com.imker.model.User;
import lombok.Builder;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Builder
public class BlogPageTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUser().isLoginLinkPresent()) {
      app.getUser().clickOnSignOutButton();
    }
  }

  @Test
  public void loadBlogPagePositiveTest() {
    app.getBlogPage().clickOnBlogLink();
    Assert.assertTrue(app.getBlogPage().isBlogBannerPresent());
  }

//  @Test
//  public void loadBlog1PagePositiveTest() {
//    app.getBlogPage().clickOnBlogLink();
//    app.getBlogPage().clickOnReadMoreLink();
//    Assert.assertTrue(app.getPostsPage().isPostsPresent());
//  }


}
