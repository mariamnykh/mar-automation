package org.configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class TestRunConfiguration {
  public static TestConfig run() {
    return ConfigFactory.create(TestConfig.class);
  }

  @Config.LoadPolicy(Config.LoadType.MERGE)
  @Config.Sources({
      "system:properties"
  })
  public interface TestConfig extends Config {
    @Key("remoteUrl")
    @DefaultValue("")
    String remoteUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();
  }
}
