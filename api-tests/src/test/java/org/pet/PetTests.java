package org.pet;

import static org.assertj.core.api.Assertions.assertThat;
import io.restassured.response.Response;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.annotations.Smoke;
import org.assertions.CategoryAssertions;
import org.assertions.GeneralAssertions;
import org.assertions.PetAssertions;
import org.assertions.TagAssertions;
import org.configs.ErrorMessages;
import org.controllers.PetController;
import org.gererators.PetGenerator;
import org.annotations.Pet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.models.GeneralResponse;
import org.models.PetDto;
import org.models.enums.PetStatus;

@Pet
public class PetTests {
  private final PetController controller = new PetController();

  private static Stream<PetStatus> statuses() {
    return
        Stream.of(PetStatus.AVAILABLE, PetStatus.SOLD, PetStatus.PENDING);
  }

  @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ": " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
  @MethodSource("statuses")
  void validateGetPetByStatusSuccessResponse(PetStatus status) {
    Response response = controller.getPetByStatus(status);
    var petsList = response.then().extract()
        .jsonPath()
        .getList("");
    assertThat(petsList)
        .isNotNull()
        .hasSizeGreaterThan(0);
  }

  @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ": " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
  @MethodSource("statuses")
  @Smoke
  void validateCreateNewPetSuccessResponse(PetStatus status) {
    var body = PetGenerator.pet(status);
    Response response = controller.createNewPet(body);
    var pet = response.then().extract().as(PetDto.class);
    var tag = pet.getTags().stream().findFirst()
        .orElseThrow(() -> new NoSuchElementException("No tag is response"));
    PetAssertions.assertThat(pet)
        .hasId(body.getId())
        .hasName(body.getName())
        .hasStatus(body.getStatus());
    CategoryAssertions.assertThat(pet.getCategory())
        .hasId(body.getCategory().getId())
        .hasName(body.getCategory().getName());
    TagAssertions.assertThat(tag)
        .hasId(tag.getId())
        .hasName(tag.getName())
        .assertAll();
  }

  @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ": " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
  @MethodSource("statuses")
  void validateGetPetByIdSuccessResponse(PetStatus status) {
    var expectedPet = controller.createNewPet(PetGenerator.pet(status)).then().extract().as(PetDto.class);
    var actualPet = controller.getPetById(expectedPet.getId()).then().extract().as(PetDto.class);
    PetAssertions.assertThat(actualPet)
        .hasId(expectedPet.getId())
        .hasName(expectedPet.getName())
        .hasStatus(expectedPet.getStatus())
        .assertAll();
  }

  @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER + ": " + ParameterizedTest.ARGUMENTS_PLACEHOLDER)
  @MethodSource("statuses")
  @Smoke
  void validateDeletePetByIdSuccessResponse(PetStatus status) {
    var expectedPet = controller.createNewPet(PetGenerator.pet(status)).then().extract().as(PetDto.class);
    controller.deletePet(expectedPet.getId()).then().statusCode(200);
    var errorResponse = controller.getPetById(expectedPet.getId()).then().extract().as(GeneralResponse.class);
    GeneralAssertions.assertThat(errorResponse)
        .hasType(ErrorMessages.ERROR.getMessage())
        .hasMessage(ErrorMessages.PET_NOT_FOUND.getMessage());
  }
}
