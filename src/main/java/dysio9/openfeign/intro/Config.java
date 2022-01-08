package dysio9.openfeign.intro;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
