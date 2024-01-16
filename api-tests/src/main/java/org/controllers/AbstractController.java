package org.controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.configs.ApiConfiguration;

public abstract class AbstractController {
  protected RequestSpecification requestSpecification = buildRequestSpecification() ;
  protected static final ApiConfiguration.ApiProps apiConfig = ApiConfiguration.endpoint();
  protected static final String API_VERSION = apiConfig.apiVersion();
  protected static final String API_KEY = apiConfig.apiKey();
  protected static final String PET_STORE_URI = apiConfig.petStoreUri();

  public RequestSpecification buildRequestSpecification() {
    return new RequestSpecBuilder()
        .setBaseUri(PET_STORE_URI)
        .setBasePath(API_VERSION)
        .setContentType(ContentType.JSON)
        .build();
  }
}
