package app.PRLeaderboard.repository;

import app.PRLeaderboard.model.PersonalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrRepository extends JpaRepository<PersonalRecord, UUID> {
}
