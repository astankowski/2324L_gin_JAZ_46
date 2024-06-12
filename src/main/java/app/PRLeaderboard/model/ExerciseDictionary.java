package app.PRLeaderboard.model;

import app.PRLeaderboard.annotation.Dictionary;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "Exercise_Dictionary")
public class ExerciseDictionary {
    @Id
    private UUID id;
    private String name;
    private String value;
}
