package dysio9.openfeign.intro.client;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import java.util.Date;

public class CustomFeignErrorDecoder implements ErrorDecoder {

  public Exception decode(String methodKey, Response response) {
    if (response.status() == 503) {
      throw new RetryableException(
          response.status(),
          "Service Unavailable",
          response.request().httpMethod(),
          new Date(System.currentTimeMillis()),
          response.request());
    } else {
      return new RuntimeException("error");
    }
  }
}