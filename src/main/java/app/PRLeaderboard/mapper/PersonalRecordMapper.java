package app.PRLeaderboard.mapper;

import app.PRLeaderboard.model.PersonalRecord;
import app.PRLeaderboard.model.PersonalRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonalRecordMapper {
        PersonalRecord toEntity(PersonalRecordDTO request);

        PersonalRecordDTO toDTO(PersonalRecord personalRecord);

        void updateEntity(PersonalRecordDTO request, @MappingTarget PersonalRecord personalRecord);

}
