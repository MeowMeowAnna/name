package com.example.Pribori.repository;

import com.example.Pribori.entity.Konvektori;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KonvektoriRepository extends JpaRepository<Konvektori, Long> {
    Konvektori findByName(String name);
    List<Konvektori> findByNameContains(String name);
}
