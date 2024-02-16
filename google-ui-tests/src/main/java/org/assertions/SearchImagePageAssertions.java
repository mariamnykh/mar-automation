package org.assertions;

import com.codeborne.selenide.Condition;
import org.pageobject.pages.SearchImagePage;

public class SearchImagePageAssertions extends BasePageAssertion<SearchImagePage, SearchImagePageAssertions>{
  public SearchImagePageAssertions(SearchImagePage page) {
    super(page);
  }

  public SearchImagePageAssertions shouldHaveSearchField(){
    page.getSearchField().shouldHave(Condition.visible);
    return this;
  }
}
