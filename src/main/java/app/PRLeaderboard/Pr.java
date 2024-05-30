package app.PRLeaderboard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "prs")
public class Pr {
    @Id
    @UuidGenerator
    private UUID id;
    private float weight;
    private Exercise exercise;
    private String ownerName;
}
