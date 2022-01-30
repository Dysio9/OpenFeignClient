package dysio9.openfeign.intro.controller;

import dysio9.openfeign.intro.client.JokeClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.SplittableRandom;

import static java.lang.Thread.sleep;
import static org.springframework.http.HttpStatus.I_AM_A_TEAPOT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("getChuckJoke")
public class Controller {
    private final JokeClient client;

    @GetMapping
    public String getChuckJoke() {
        return client.getRandomJoke();
    }

    @GetMapping("/{milliseconds}")
    public String getChuckJokeWithDelay(@PathVariable int milliseconds) {
        return client.getRandomJokeWithDelay(milliseconds);
    }

    @GetMapping("/failureProbability/{percent}")
    public String getRandomWithFailure(@PathVariable int percent) {
        log.info("   ======== Request with failure probability equals " + percent + "% received. ========");
        return client.getRandomJokeWithFailureProbability(percent);
    }
}
