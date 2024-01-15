package org.controllers;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.models.PetDto;
import org.models.UserDto;

@Slf4j
public class UserController extends AbstractController{

  public Response createNewUser(UserDto body){
    log.info("Creating new user with body: " + body);
    return given(requestSpecification)
        .body(body)
        .post("/user");
  }
}
