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

    public PrResponse addPr(PrCreateRequest request){
        Pr newPr = new Pr();
        newPr.setWeight(request.getWeight());
        newPr.setExercise(request.getExercise());
        newPr.setOwnerName(request.getOwnerName());

        Pr saved = repository.save(newPr);

        PrResponse response = new PrResponse();
        response.setId(saved.getId());
        response.setWeight(saved.getWeight());
        response.setExercise(saved.getExercise());
        response.setOwnerName(saved.getOwnerName());

        return response;
    }

    public List<PrResponse> getAllPrs() {
        return repository
                .findAll()
                .stream()
                .map(pr -> new PrResponse(pr.getId(), pr.getWeight(), pr.getExercise(), pr.getOwnerName()))
                .collect(Collectors.toList());
    }

    public PrResponse getPr(UUID id) {
        Pr saved = repository.getReferenceById(id);

        PrResponse response = new PrResponse();
        response.setId(saved.getId());
        response.setWeight(saved.getWeight());
        response.setExercise(saved.getExercise());
        response.setOwnerName(saved.getOwnerName());

        return response;
    }

    public PrResponse updatePr(UUID id, PrUpdateRequest request) {
        Pr Pr = repository.getReferenceById(id);
        Pr.setWeight(request.getWeight());
        Pr.setExercise(request.getExercise());
        Pr.setOwnerName(request.getOwnerName());

        PrResponse response = new PrResponse();
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

