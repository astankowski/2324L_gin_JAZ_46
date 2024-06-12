package app.PRLeaderboard.controller;

import app.PRLeaderboard.model.PersonalRecordDTO;
import app.PRLeaderboard.service.PersonalRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor

public class PersonalRecordController {
    private final PersonalRecordService service;


    @PostMapping("/addPersonalRecord")
    public ResponseEntity<PersonalRecordDTO> addPersonalRecord(@Valid @RequestBody PersonalRecordDTO request){
        return ok(service.addPersonalRecord(request));
    }

    @GetMapping("/getPersonalRecords")
    public ResponseEntity<List<PersonalRecordDTO>> getAllPersonalRecords(){
        return ok(service.getAllPersonalRecords());
    }

    @GetMapping("/getPersonalRecord/{id}")
    public ResponseEntity<PersonalRecordDTO> getPersonalRecord(@PathVariable UUID id){
        return ok(service.getPersonalRecord(id));
    }

    @PutMapping("/updatePersonalRecord/{id}")
    public ResponseEntity<PersonalRecordDTO> updatePersonalRecord(@PathVariable UUID id, @Valid @RequestBody PersonalRecordDTO request){
        return ok(service.updatePersonalRecord(id, request));
    }

    @DeleteMapping("/deletePersonalRecord/{id}")
    public ResponseEntity<Void> deletePersonalRecord (@PathVariable UUID id){
        service.deletePersonalRecord(id);
        return ok().build();
    }

}
