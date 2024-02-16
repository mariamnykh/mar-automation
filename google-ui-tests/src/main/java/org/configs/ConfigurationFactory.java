package org.configs;

import lombok.Getter;

@Getter
public class ConfigurationFactory {
  private static ConfigurationFactory instance;
  protected ApplicationConfiguration.ApiProps applicationConfiguration = ApplicationConfiguration.endpoint();
  protected TestRunConfiguration.TestConfig testConfig = TestRunConfiguration.run();

  public static ConfigurationFactory getConfigurationFactory(){
    if (instance == null){
      return new ConfigurationFactory();
    }
    else return instance;
  }
}
