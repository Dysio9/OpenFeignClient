package dysio9.openfeign.intro.client;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

public class CustomJokeConfig {

  @Bean
  Retryer FeignRetryer() {
    return new Retryer.Default();
  }

}
