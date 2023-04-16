package com.example.Pribori.service;

import com.example.Pribori.dto.KonvektoriDto;

import java.util.List;

public interface KonvektoriService {
    KonvektoriDto saveKonvektori(KonvektoriDto konvektoriDto);

    void deleteKonvektori(Long id);

    KonvektoriDto findByNameK(String name);

    List<KonvektoriDto> findAllK();
}
