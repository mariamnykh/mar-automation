package org.pageobject.component;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;


@Getter
public class LeftMenu extends Component{
  private SelenideElement closeButton;
  private SelenideElement logo;

  protected LeftMenu() {
    super($(".side-menu"));
    closeButton = component.$(".side-menu-close");
    logo = component.$(".side-menu__logo");
  }

  public void clickCloseButton(){
    closeButton.click();
  }

  public void clickLogo(){
    logo.click();
  }
}
