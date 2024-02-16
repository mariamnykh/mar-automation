package org.app;

import static org.assertions.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.pageobject.component.Header;
import org.pageobject.pages.GmailPage;
import org.pageobject.pages.HomePage;
import org.pageobject.pages.SearchImagePage;

class GoogleHeaderTests extends BaseTest {

  @Test
  void userShouldBeAbleToOpenGmailPage() {
    new HomePage().openPage();
    GmailPage gmailPage = new Header()
        .clickGmailLink();
    assertThat(gmailPage)
        .isOpened()
        .shouldHaveEmailField();
  }

  @Test
  void userShouldBeAbleToOpenSearchImagePage() {
    new HomePage().openPage();
    SearchImagePage searchImagePage = new Header()
        .clickImageLink();
    assertThat(searchImagePage)
        .isOpened()
        .shouldHaveSearchField();
  }
}
