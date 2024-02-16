package org.driver;

import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomWebDriverListener implements WebDriverListener {
  private final SelenideElement skeleton = $(".top-wrap--skeleton");

  @Override
  public void beforeClick(WebElement element) {
    skeleton.shouldBe(Condition.disappear);
  }
}
