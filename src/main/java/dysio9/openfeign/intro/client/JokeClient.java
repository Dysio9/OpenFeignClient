package dysio9.openfeign.intro.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "chuckNorrisJokes",
    url = "${joke.api.url:http://localhost:8081/getChuckJoke}",
    configuration = CustomJokeConfig.class)
public interface JokeClient {

  @GetMapping(path = "/")
  String getRandomJoke();

  @GetMapping(value = "/sleep/{milliseconds}")
  String getRandomJokeWithDelay(@PathVariable int milliseconds);

  @GetMapping(path = "/failureProbability/{percent}")
  String getRandomJokeWithFailureProbability(@PathVariable int percent);
}
