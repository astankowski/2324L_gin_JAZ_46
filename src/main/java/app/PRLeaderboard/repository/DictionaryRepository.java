package app.PRLeaderboard.repository;

import app.PRLeaderboard.annotation.Dictionary;
import app.PRLeaderboard.model.ExerciseDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;

public interface DictionaryRepository extends JpaRepository<ExerciseDictionary, UUID> {
    @Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ExerciseDictionary c WHERE c.name = :name AND c.value = :value")
    boolean existsInDictionary(@Param("name") String name, @Param("value") String value);
}