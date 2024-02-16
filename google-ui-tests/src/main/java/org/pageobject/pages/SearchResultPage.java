package org.pageobject.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.annotations.Url;

@Getter
@Url("/search?q={0}")
public class SearchResultPage extends BasePage<SearchResultPage>{
  private final ElementsCollection results = $$("#search [data-hveid] a");
  private final SelenideElement searchField = $(".RNNXgb textarea");
  private final SelenideElement logo = $(".logo");

  public SearchResultPage clickLogo(){
    logo.click();
    return this;
  }
}
