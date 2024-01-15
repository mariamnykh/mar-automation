package org.controllers;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.models.PetDto;
import org.models.enums.PetStatus;

@Slf4j
public class PetController extends AbstractController{

  public Response getPetByStatus(PetStatus status){
    return given(requestSpecification)
        .queryParam("status", status.getDisplayName())
        .get("/pet/findByStatus");
  }

  public Response createNewPet(PetDto body){
    log.info("Creating new pet with body: " + body);
    return given(requestSpecification)
        .body(body)
        .post("/pet");
  }

  public Response deletePet(String id){
    log.info("Delete pet with id: " + id);
    return given(requestSpecification)
        .header("api_key", API_KEY)
        .delete("/pet/{0}", id);
  }

  public Response getPetById(String id){
    return given(requestSpecification)
        .get("/pet/{0}", id);
  }

  public Response updatePetById(PetDto dto, String id){
    return given(requestSpecification)
        .formParam("name", dto.getName())
        .formParam("status", dto.getStatus())
        .post("/pet/{0}", id);
  }
}
