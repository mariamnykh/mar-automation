package org.assertions;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.pageobject.pages.SearchResultPage;

public class SearchResultPageAssertion extends BasePageAssertion<SearchResultPage, SearchResultPageAssertion>{
  public SearchResultPageAssertion(SearchResultPage page) {
    super(page);
  }

  public SearchResultPageAssertion shouldHaveLogo(){
    page.getLogo().shouldHave(Condition.visible);
    return this;
  }

  public SearchResultPageAssertion shouldHaveSearchFieldAutoPopulated(String text){
    page.getSearchField().shouldHave(Condition.text(text));
    return this;
  }

  public SearchResultPageAssertion shouldHaveResults(){
    page.getResults().shouldHave(CollectionCondition.sizeGreaterThan(1));
    return this;
  }
}
