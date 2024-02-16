package org.pageobject.pages;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.annotations.Url;

@Url("/")
@Getter
public class GmailPage extends BasePage<GmailPage>{
  private SelenideElement emailField = $("[type='email']");
}
