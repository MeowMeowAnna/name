package com.example.Pribori.repository;

import com.example.Pribori.entity.Obogrevateli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObogrevateliRepository extends JpaRepository<Obogrevateli, Long> {
    Obogrevateli findByName(String name);
    List<Obogrevateli> findByNameContains(String name);
    List<Obogrevateli> findAllByPriceGreaterThanEqual(Long price);
}
