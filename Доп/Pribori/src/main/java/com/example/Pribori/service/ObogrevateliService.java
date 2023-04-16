package com.example.Pribori.service;

import com.example.Pribori.dto.ObogrevateliDto;

import java.util.List;

public interface ObogrevateliService {

    ObogrevateliDto saveObogrevateli(ObogrevateliDto obogrevateliDto);

    void deleteObogrevateli(Long id);

    ObogrevateliDto findByNameOb(String name);

    List<ObogrevateliDto> findAllOb();

    List<ObogrevateliDto> findObogrev(Long price);
}
