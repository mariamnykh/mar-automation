package org.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class ApplicationConfiguration {
  public static ApiProps endpoint() {
    return ConfigFactory.create(ApiProps.class);
  }

  @Config.LoadPolicy(Config.LoadType.MERGE)
  @Config.Sources({
      "classpath:app.properties",
      "system:properties"
  })
  public interface ApiProps extends Config {
    @Key("app.uri")
    String appUri();

    @Key("gmail.app.uri")
    String gmailAppUri();
  }
}
