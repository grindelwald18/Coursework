package com.example.salonofcars.repositories;

import com.example.salonofcars.models.EngineVolume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EngineVolumeRepository extends JpaRepository<EngineVolume, Integer> {
    List<EngineVolume> findByEngineVolume(String engineVolume);
}
