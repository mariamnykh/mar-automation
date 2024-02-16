package org.pageobject.component;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.pageobject.pages.GmailPage;
import org.pageobject.pages.SearchImagePage;

@Getter
public class Header extends Component{
  private final SelenideElement leftMenuButton;
  private final SelenideElement searchField;
  private final SelenideElement gmailLink;
  private final SelenideElement imageLink;
  public Header() {
    super($(".LX3sZb"));
    leftMenuButton = component.$(".header__button");
    searchField = component.$(".search-form__back");
    imageLink = component.$$(".gb_F").get(1);
    gmailLink = component.$(".gb_F");
  }

  public GmailPage clickGmailLink(){
    gmailLink.scrollIntoView(true).click();
    return new GmailPage();
  }

  public SearchImagePage clickImageLink(){
    imageLink.scrollIntoView(true).click();
    return new SearchImagePage();
  }
}
