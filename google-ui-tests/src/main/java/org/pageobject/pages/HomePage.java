package org.pageobject.pages;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.annotations.Url;

@Url("/")
@Getter
public class HomePage extends BasePage<HomePage> {
  private final SelenideElement searchField = $(".RNNXgb textarea");

  public void searchText(String text) {
    searchField.click();
    searchField.val(text);
    searchField.pressEnter();
  }
}
