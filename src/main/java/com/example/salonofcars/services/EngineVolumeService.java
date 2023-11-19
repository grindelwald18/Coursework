package com.example.salonofcars.services;

import com.example.salonofcars.models.EngineVolume;
import com.example.salonofcars.repositories.EngineVolumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineVolumeService {
    private final EngineVolumeRepository engineVolumeRepository;
    public List<EngineVolume> getEngineVolume(){
        return engineVolumeRepository.findAll();
    }
    public EngineVolume addEngineVolume(EngineVolume engineVolume){
        engineVolumeRepository.save(engineVolume);
        return engineVolume;
    }

    public void deleteEngineVolume(int id){
        engineVolumeRepository.deleteById(id);
    }
    public void updeteEngineVolume(int id, EngineVolume updeteEngineVolume){
        updeteEngineVolume.setId(id);
        engineVolumeRepository.save(updeteEngineVolume);

    }
}
