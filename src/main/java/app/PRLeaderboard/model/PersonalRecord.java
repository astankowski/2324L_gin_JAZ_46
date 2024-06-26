package app.PRLeaderboard.model;

import app.PRLeaderboard.annotation.Dictionary;
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
    @Dictionary("Exercise_Dictionary")
    private String exercise;
    private String ownerName;
}
