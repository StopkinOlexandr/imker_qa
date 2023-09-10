package com.imker.fw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class ApplicationManager {

  String browser;
  public WebDriver driver;

  UserHelper user;
  ContactHelper contact;
  HomePageHelper homePage;
  BlogPageHelper blogPage;
  AboutUsPegeHelper aboutUsPage;
  AdminPageHelper adminPage;
  ContactPageHelper contactPage;
  GalleryPageHelper galleryPage;
  PostsPageHelper postsPage;
  EventsPageHelper eventsPage;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public UserHelper getUser() {
    return user;
  }

  public ContactPageHelper getContact() {
    return contactPage;
  }

  public HomePageHelper getHomePage() {
    return homePage;
  }

  public BlogPageHelper getBlogPage() {
    return blogPage;
  }

  public PostsPageHelper getPostsPage() { return postsPage; }

  public EventsPageHelper getEventsPage() { return eventsPage; }

  public GalleryPageHelper getGalleryPage() { return galleryPage; }


  public void init() {
    System.err.close();

    if (browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
//            EdgeOptions options = new EdgeOptions();
//            options.addArguments("remote-allow-origins=*");
//            driver = new EdgeDriver(options);
      driver = new EdgeDriver();
    }

    driver.get("http://localhost:5173/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    user = new UserHelper(driver);
    contact = new ContactHelper(driver);
    homePage = new HomePageHelper(driver);
    blogPage = new BlogPageHelper(driver);
    postsPage = new PostsPageHelper(driver);
    eventsPage = new EventsPageHelper(driver);
    galleryPage = new GalleryPageHelper(driver);

  }

  public void stop() {
    driver.quit();
  }

}
