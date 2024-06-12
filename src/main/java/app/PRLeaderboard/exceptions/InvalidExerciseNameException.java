package app.PRLeaderboard.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidExerciseNameException extends RuntimeException{
    public InvalidExerciseNameException(String message) {
        super(message);
    }
}
