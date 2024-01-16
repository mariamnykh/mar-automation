package org.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
public class ApiConfiguration {
  public static ApiProps endpoint() {
    return ConfigFactory.create(ApiProps.class);
  }

  @Config.LoadPolicy(Config.LoadType.MERGE)
  @Config.Sources({
      "classpath:api-configuration.properties",
      "system:properties"
  })
  public interface ApiProps extends Config {
    @Key("pet.store.uri")
    String petStoreUri();

    @Key("api.key")
    String apiKey();

    @Key("api.version")
    String apiVersion();
  }
}
