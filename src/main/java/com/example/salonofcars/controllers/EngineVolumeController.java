package com.example.salonofcars.controllers;

import com.example.salonofcars.models.EngineVolume;
import com.example.salonofcars.services.EngineVolumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engine")
@RequiredArgsConstructor
public class EngineVolumeController {
    private final EngineVolumeService engineVolumeService;
    @GetMapping
    public ResponseEntity<List<EngineVolume>> getAllEngineVolume(){
        return ResponseEntity.ok().body(engineVolumeService.getEngineVolume());
    }
    @PostMapping("/add")
    public ResponseEntity<EngineVolume> addEngineVolume(@RequestBody EngineVolume engineVolume){
        engineVolumeService.addEngineVolume(engineVolume);
        return ResponseEntity.status(HttpStatus.CREATED).body(engineVolume);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delEngineVolume(@PathVariable Integer id){
        engineVolumeService.deleteEngineVolume(id);
        String message = "EngineVolume с идентификатором " + id + " успешно удален.";
        return ResponseEntity.ok(message);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String > updateEngineVolume(@PathVariable Integer id, @RequestBody EngineVolume updateEngineVolume){
        engineVolumeService.updeteEngineVolume(id, updateEngineVolume);
        return ResponseEntity.ok("Данные обновлены");
    }

}
