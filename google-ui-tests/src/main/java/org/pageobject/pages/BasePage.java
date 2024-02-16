package org.pageobject.pages;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import java.text.MessageFormat;
import org.annotations.Url;
import org.configs.ConfigurationFactory;

public abstract class BasePage<T> {
  public void openPage(Object... params) {
    var pageUri = getUrl(params);
    open(ConfigurationFactory.getConfigurationFactory().getApplicationConfiguration().appUri()
        + pageUri);
  }

  public boolean isOpened(Object... params) {
    var pageUri = getUrl(params);
    return getWebDriver().getCurrentUrl().contains(pageUri);
  }

  public String getUrl(Object... params) {
    Url uri = this.getClass().getAnnotation(Url.class);
    return MessageFormat.format(uri.value(), params);
  }
}
