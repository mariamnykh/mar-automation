package org.gererators;

import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.models.UserDto;

public class UserGenerator extends AbstractGenerator {
  public static UserDto user(String userName) {
    return UserDto.builder()
        .id(Integer.parseInt(RandomStringUtils.randomNumeric(6)))
        .username(userName)
        .firstName(AUTO_PREFIX + RandomStringUtils.randomAlphabetic(4))
        .lastName(AUTO_PREFIX + RandomStringUtils.randomAlphabetic(4))
        .phone(RandomStringUtils.randomNumeric(4))
        .userStatus(Integer.parseInt(RandomStringUtils.randomNumeric(4)))
        .build();
  }
}
