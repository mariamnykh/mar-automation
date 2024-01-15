package org.pet;

import io.restassured.response.Response;
import org.annotations.Smoke;
import org.annotations.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertions.GeneralAssertions;
import org.controllers.UserController;
import org.gererators.UserGenerator;
import org.junit.jupiter.api.Test;
import org.models.GeneralResponse;

public class UserTests {
  private final UserController controller = new UserController();

  @Test
  @User
  @Smoke
  void validatePostNewUserSuccessResponse() {
    var userName = RandomStringUtils.randomAlphabetic(4);
    Response response = controller.createNewUser(UserGenerator.user(userName));
    var userResponse = response.then().extract()
        .as(GeneralResponse.class);
    GeneralAssertions.assertThat(userResponse)
        .hasStatusCode("200");
  }
}
