package org.pageobject.pages;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.annotations.Url;

@Url("/imghp")
@Getter
public class SearchImagePage extends BasePage<SearchImagePage> {
  private final SelenideElement searchField = $(".RNNXgb textarea");
}
