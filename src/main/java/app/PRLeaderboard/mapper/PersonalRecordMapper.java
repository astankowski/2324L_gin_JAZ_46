package app.PRLeaderboard.mapper;

import app.PRLeaderboard.model.PersonalRecord;
import app.PRLeaderboard.model.PersonalRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonalRecordMapper {
        PersonalRecordMapper INSTANCE = Mappers.getMapper(PersonalRecordMapper.class);
        @Mapping(target = "id", ignore = true)
        PersonalRecord toPr(PersonalRecordDTO request);

        PersonalRecordDTO toPrResponse(PersonalRecord personalRecord);

        PersonalRecord updatePrFromDTO(PersonalRecordDTO request, @MappingTarget PersonalRecord personalRecord);
}
