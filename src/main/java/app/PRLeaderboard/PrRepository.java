package app.PRLeaderboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrRepository extends JpaRepository<Pr, UUID> {
}
