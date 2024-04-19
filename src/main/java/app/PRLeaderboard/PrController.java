package app.PRLeaderboard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor

public class PrController {
    private final PrService service;


    @PostMapping("/addPr")
    public PrResponse createPr(@RequestBody PrCreateRequest request){
        return service.addPr(request);
    }

    @GetMapping("/getPrs")
    public List<PrResponse> getPrs(){
        return service.getAllPrs();
    }

    @GetMapping("/getPr/{id}")
    public PrResponse getPr(@PathVariable UUID id){
        return service.getPr(id);
    }

    @PutMapping("/updatePr/{id}")
    public PrResponse updatePr(@PathVariable UUID id, @RequestBody PrUpdateRequest request){
        return service.updatePr(id, request);
    }

    @DeleteMapping("/deletePr/{id}")
    public void deletePr(@PathVariable UUID id){
        service.deletePr(id);
    }

}