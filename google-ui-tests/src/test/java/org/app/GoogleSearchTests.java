package org.app;

import static org.assertions.Assertions.assertThat;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.pageobject.pages.HomePage;
import org.pageobject.pages.SearchResultPage;

class GoogleSearchTests extends BaseTest {

  private static Stream<String> textToSearch() {
    return
        Stream.of("selenide", "java", "gradle");
  }

  @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ": " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
  @MethodSource("textToSearch")
  void userShouldBeAbleToSearchText(String textToSearch) {
    HomePage homePage = new HomePage();
    homePage.openPage();
    homePage.searchText(textToSearch);
    SearchResultPage resultPage = new SearchResultPage();
    assertThat(resultPage)
        .isOpened(textToSearch)
        .shouldHaveLogo()
        .shouldHaveSearchFieldAutoPopulated(textToSearch)
        .shouldHaveResults();
  }

  @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ": " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
  @MethodSource("textToSearch")
  void userShouldBeAbleToNavigateToHomePageAfterClickingLogo(String textToSearch) {
    SearchResultPage searchResultPage = new SearchResultPage();
    searchResultPage.openPage(textToSearch);
    searchResultPage.clickLogo();
    HomePage homePage = new HomePage();
    assertThat(homePage)
        .isOpened()
        .shouldHaveSearchFieldEmpty();
  }
}
