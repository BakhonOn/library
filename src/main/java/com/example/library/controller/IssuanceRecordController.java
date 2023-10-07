package com.example.library.controller;
import com.example.library.models.IssuanceRecord;
import com.example.library.service.IssuanceRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("record")
public class IssuanceRecordController {
    private final IssuanceRecordService recordService;
    @PostMapping("/new_record")
    public ResponseEntity<Optional<IssuanceRecord>> createNewRecord(@RequestBody IssuanceRecord issuanceRecord){
        return new ResponseEntity<>(recordService.createIssuanceRecord(issuanceRecord), HttpStatus.OK);
    }
    @GetMapping("get_record_by_id")
    public ResponseEntity<Optional<IssuanceRecord>> getRecord(@RequestParam Long id){
        return new ResponseEntity<>(recordService.getRecordById(id), HttpStatus.OK);
    }
    @PutMapping("update_record")
    public ResponseEntity<Optional<IssuanceRecord>> updateRecord(@RequestBody IssuanceRecord issuanceRecord){
        return new ResponseEntity<>(recordService.updateIssuanceRecord(issuanceRecord), HttpStatus.OK);
    }
    @DeleteMapping("delete_record")
    public ResponseEntity<Optional<Boolean>> deleteRecordById(@RequestParam Long id){
        return new ResponseEntity<>(recordService.deleteIssuanceRecordById(id), HttpStatus.OK);
    }

}
