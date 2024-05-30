package app.PRLeaderboard.model;

import lombok.*;

import java.util.UUID;

@Data
public class PersonalRecordDTO {
    private UUID id;
    private float weight;
    private Exercise exercise;
    private String ownerName;
}
