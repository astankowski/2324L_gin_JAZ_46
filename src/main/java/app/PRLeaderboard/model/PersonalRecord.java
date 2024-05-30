package app.PRLeaderboard.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "Personal_Records")
public class PersonalRecord {
    @Id
    @UuidGenerator
    private UUID id;
    private float weight;
    @Enumerated(EnumType.STRING)
    private Exercise exercise;
    private String ownerName;
}
