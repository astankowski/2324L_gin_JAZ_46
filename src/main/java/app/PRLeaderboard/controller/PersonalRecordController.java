package app.PRLeaderboard.controller;

import app.PRLeaderboard.model.PersonalRecordCreateRequest;
import app.PRLeaderboard.model.PersonalRecordDTO;
import app.PRLeaderboard.service.PersonalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor

public class PersonalRecordController {
    private final PersonalRecordService service;


    @PostMapping("/addPr")
    public PersonalRecordDTO createPr(@RequestBody PersonalRecordCreateRequest request){
        return service.addPr(request);
    }

    @GetMapping("/getPrs")
    public List<PersonalRecordDTO> getPrs(){
        return service.getAllPrs();
    }

    @GetMapping("/getPr/{id}")
    public PersonalRecordDTO getPr(@PathVariable UUID id){
        return service.getPr(id);
    }

    @PutMapping("/updatePr/{id}")
    public PersonalRecordDTO updatePr(@PathVariable UUID id, @RequestBody PersonalRecordCreateRequest request){
        return service.updatePr(id, request);
    }

    @DeleteMapping("/deletePr/{id}")
    public void deletePr(@PathVariable UUID id){
        service.deletePr(id);
    }

}
