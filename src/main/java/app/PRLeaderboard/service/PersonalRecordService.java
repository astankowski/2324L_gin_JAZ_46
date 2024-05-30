package app.PRLeaderboard.service;

import app.PRLeaderboard.model.PersonalRecord;
import app.PRLeaderboard.model.PersonalRecordCreateRequest;
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
    //Pr pr = PrMapper.INSTANCE.toPr(PrDTO prResponse);

    public PersonalRecordDTO addPr(PersonalRecordCreateRequest request){
        PersonalRecord newPersonalRecord = new PersonalRecord();
        newPersonalRecord.setWeight(request.getWeight());
        newPersonalRecord.setExercise(request.getExercise());
        newPersonalRecord.setOwnerName(request.getOwnerName());

        PersonalRecord saved = repository.save(newPersonalRecord);

        PersonalRecordDTO response = new PersonalRecordDTO();
        response.setId(saved.getId());
        response.setWeight(saved.getWeight());
        response.setExercise(saved.getExercise());
        response.setOwnerName(saved.getOwnerName());

        return response;
    }

    public List<PersonalRecordDTO> getAllPrs() {
        return repository
                .findAll()
                .stream()
                .map(personalRecord -> new PersonalRecordDTO(personalRecord.getId(), personalRecord.getWeight(), personalRecord.getExercise(), personalRecord.getOwnerName()))
                .collect(Collectors.toList());
    }

    public PersonalRecordDTO getPr(UUID id) {
        PersonalRecord saved = repository.getReferenceById(id);

        PersonalRecordDTO response = new PersonalRecordDTO();
        response.setId(saved.getId());
        response.setWeight(saved.getWeight());
        response.setExercise(saved.getExercise());
        response.setOwnerName(saved.getOwnerName());

        return response;
    }

    public PersonalRecordDTO updatePr(UUID id, PersonalRecordDTO request) {
        PersonalRecord PersonalRecord = repository.getReferenceById(id);
        //toPr(PrDTO request);
        PersonalRecord.setWeight(request.getWeight());
        PersonalRecord.setExercise(request.getExercise());
        PersonalRecord.setOwnerName(request.getOwnerName());

        PersonalRecordDTO response = new PersonalRecordDTO();
        response.setId(PersonalRecord.getId());
        response.setWeight(PersonalRecord.getWeight());
        response.setExercise(PersonalRecord.getExercise());
        response.setOwnerName(PersonalRecord.getOwnerName());
        return response;
    }

    public void deletePr(UUID id) {
        repository.deleteById(id);
    }
}

