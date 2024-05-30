package app.PRLeaderboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor

public class PersonalRecordCreateRequest {
    private float weight;
    private Exercise exercise;
    private String ownerName;
}
