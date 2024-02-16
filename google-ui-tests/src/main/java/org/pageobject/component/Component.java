package org.pageobject.component;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public abstract class Component {
  protected SelenideElement component;
  protected Component(SelenideElement component) {
    this.component = component.should(Condition.appear);
  }
}
