package app.PRLeaderboard;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrMapper {
        PrMapper INSTANCE = Mappers.getMapper(PrMapper.class);
        @Mapping(target = "id", ignore = true)
        Pr toPr(PrDTO request);

        PrDTO toPrResponse(Pr pr);

        Pr updatePrFromDTO(PrDTO request, @MappingTarget Pr pr);
}
