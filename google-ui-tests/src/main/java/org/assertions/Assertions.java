package org.assertions;

import org.pageobject.pages.BasePage;
import org.pageobject.pages.GmailPage;
import org.pageobject.pages.HomePage;
import org.pageobject.pages.SearchImagePage;
import org.pageobject.pages.SearchResultPage;

public abstract class Assertions {

  public static BasePageAssertion assertThat(BasePage page){
    return new BasePageAssertion(page);
  }

  public static SearchResultPageAssertion assertThat(SearchResultPage page){
    return new SearchResultPageAssertion(page);
  }

  public static HomePageAssertions assertThat(HomePage page){
    return new HomePageAssertions(page);
  }

  public static GmailPageAssertions assertThat(GmailPage page){
    return new GmailPageAssertions(page);
  }

  public static SearchImagePageAssertions assertThat(SearchImagePage page){
    return new SearchImagePageAssertions(page);
  }
}
