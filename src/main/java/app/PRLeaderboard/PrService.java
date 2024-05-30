package app.PRLeaderboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrService {

    private final PrRepository repository;
    //Pr pr = PrMapper.INSTANCE.toPr(PrDTO prResponse);

    public PrDTO addPr(PrCreateRequest request){
        Pr newPr = new Pr();
        newPr.setWeight(request.getWeight());
        newPr.setExercise(request.getExercise());
        newPr.setOwnerName(request.getOwnerName());

        Pr saved = repository.save(newPr);

        PrDTO response = new PrDTO();
        response.setId(saved.getId());
        response.setWeight(saved.getWeight());
        response.setExercise(saved.getExercise());
        response.setOwnerName(saved.getOwnerName());

        return response;
    }

    public List<PrDTO> getAllPrs() {
        return repository
                .findAll()
                .stream()
                .map(pr -> new PrDTO(pr.getId(), pr.getWeight(), pr.getExercise(), pr.getOwnerName()))
                .collect(Collectors.toList());
    }

    public PrDTO getPr(UUID id) {
        Pr saved = repository.getReferenceById(id);

        PrDTO response = new PrDTO();
        response.setId(saved.getId());
        response.setWeight(saved.getWeight());
        response.setExercise(saved.getExercise());
        response.setOwnerName(saved.getOwnerName());

        return response;
    }

    public PrDTO updatePr(UUID id, PrDTO request) {
        Pr Pr = repository.getReferenceById(id);
        //toPr(PrDTO request);
        Pr.setWeight(request.getWeight());
        Pr.setExercise(request.getExercise());
        Pr.setOwnerName(request.getOwnerName());

        PrDTO response = new PrDTO();
        response.setId(Pr.getId());
        response.setWeight(Pr.getWeight());
        response.setExercise(Pr.getExercise());
        response.setOwnerName(Pr.getOwnerName());
        return response;
    }

    public void deletePr(UUID id) {
        repository.deleteById(id);
    }
}

