package org.controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractController {
  protected RequestSpecification requestSpecification = buildRequestSpecification() ;
  public static final String API_VERSION = "v2";
  public static final String API_KEY = "special-key";
  public static final String PET_STORE_URI = "https://petstore.swagger.io/";

  public RequestSpecification buildRequestSpecification() {
    return new RequestSpecBuilder()
        .setBaseUri(PET_STORE_URI)
        .setBasePath(API_VERSION)
        .setContentType(ContentType.JSON)
        .build();
  }
}
