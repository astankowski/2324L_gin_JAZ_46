package app.PRLeaderboard.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "exercise", url = "http://localhost:8081")
public interface ExerciseClient {
    @GetMapping("/getPersonalRecord/{id}")
    ResponseEntity<String> getExercise(@PathVariable("id") UUID id);
}