package org.assertions;

import static com.codeborne.selenide.Selenide.Wait;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.SoftAssertionError;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.TimeoutException;
import org.pageobject.pages.BasePage;

public class BasePageAssertion <T extends BasePage, A extends BasePageAssertion>{
  protected final T page;

  public BasePageAssertion(T page) {
    this.page = page;
  }

  public A isOpened(Object... params) {
    Wait()
        .withTimeout(Duration.ofSeconds(15L))
        .pollingEvery(Duration.ofSeconds(1L))
        .withMessage(() -> new SoftAssertionError(String.format("\nExpected url: %s, but was opened: %s",
            page.getUrl(params),
            WebDriverRunner.getWebDriver().getCurrentUrl()),  List.of(new TimeoutException()), false).toString())
        .until(driver -> page.isOpened(params));
    return (A) this;
  }

  public A isNotOpened(Object... params) {
    Wait()
        .withTimeout(Duration.ofSeconds(15L))
        .pollingEvery(Duration.ofSeconds(1L))
        .withMessage(() -> new SoftAssertionError(String.format("\nExpected url should not be: %s",
            page.getUrl(params)),  List.of(new TimeoutException()), false).getMessage())
        .until(driver -> !page.isOpened(params));
    return (A) this;
  }
}
