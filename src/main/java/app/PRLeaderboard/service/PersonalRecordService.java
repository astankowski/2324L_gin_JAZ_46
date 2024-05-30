package app.PRLeaderboard.service;

import app.PRLeaderboard.mapper.PersonalRecordMapper;
import app.PRLeaderboard.model.PersonalRecord;
import app.PRLeaderboard.model.PersonalRecordDTO;
import app.PRLeaderboard.repository.PrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonalRecordService {
    private final PrRepository repository;
    private final PersonalRecordMapper mapper;
    public PersonalRecordDTO addPersonalRecord(PersonalRecordDTO request){
        PersonalRecord saved = repository.save(mapper.toEntity(request));
        return mapper.toDTO(saved);
    }

    public List<PersonalRecordDTO> getAllPersonalRecords() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonalRecordDTO getPersonalRecord(UUID id) {
        return mapper.toDTO(repository.getReferenceById(id));
    }

    public PersonalRecordDTO updatePersonalRecord(UUID id, PersonalRecordDTO request) {
        PersonalRecord personalRecord = repository.getReferenceById(id);
        mapper.updateEntity(request, personalRecord);
        PersonalRecord saved = repository.save(personalRecord);
        return mapper.toDTO(saved);
    }

    public void deletePersonalRecord(UUID id) {
        repository.deleteById(id);
    }
}
