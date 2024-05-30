package app.PRLeaderboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor

public class PersonalRecordDTO {
    private UUID id;
    private float weight;
    private Exercise exercise;
    private String ownerName;
}