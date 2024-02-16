package org.assertions;

import com.codeborne.selenide.Condition;
import org.pageobject.pages.HomePage;

public class HomePageAssertions extends BasePageAssertion<HomePage,HomePageAssertions> {
  public HomePageAssertions(HomePage page) {
    super(page);
  }

  public HomePageAssertions shouldHaveSearchFieldEmpty(){
    page.getSearchField().shouldHave(Condition.attribute("aria-expanded", "false"));
    return this;
  }
}
