package org.assertions;

import com.codeborne.selenide.Condition;
import org.pageobject.pages.GmailPage;

public class GmailPageAssertions extends BasePageAssertion<GmailPage, GmailPageAssertions> {
  public GmailPageAssertions(GmailPage page) {
    super(page);
  }

  public GmailPageAssertions shouldHaveEmailField() {
    page.getEmailField().shouldHave(Condition.visible);
    return this;
  }
}
