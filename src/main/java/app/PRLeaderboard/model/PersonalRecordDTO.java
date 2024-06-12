package app.PRLeaderboard.model;

import app.PRLeaderboard.annotation.Dictionary;
import jakarta.validation.Valid;
import lombok.*;

import java.util.UUID;

@Data
public class PersonalRecordDTO {
    private UUID id;
    private float weight;
    @Dictionary("Exercise_Dictionary")
    private String exercise;
    private String ownerName;
}
