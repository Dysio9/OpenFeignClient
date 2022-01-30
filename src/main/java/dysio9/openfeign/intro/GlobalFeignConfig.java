package dysio9.openfeign.intro;

import dysio9.openfeign.intro.client.CustomFeignErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    ErrorDecoder feignErrorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}
