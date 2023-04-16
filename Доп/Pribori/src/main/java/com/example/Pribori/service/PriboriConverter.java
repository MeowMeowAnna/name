package com.example.Pribori.service;


import com.example.Pribori.dto.CommentDto;
import com.example.Pribori.dto.KonvektoriDto;
import com.example.Pribori.dto.ObogrevateliDto;
import com.example.Pribori.entity.Comment;
import com.example.Pribori.entity.Konvektori;
import com.example.Pribori.entity.Obogrevateli;
import org.springframework.stereotype.Component;

@Component
public class PriboriConverter {

    public Obogrevateli fromObDtoToOb (ObogrevateliDto obogrevateliDto){
        Obogrevateli obogrevateli = new Obogrevateli();
        obogrevateli.setId(obogrevateliDto.getId());
        obogrevateli.setName(obogrevateliDto.getName());
        obogrevateli.setColor(obogrevateliDto.getColor());
        obogrevateli.setMaxMohch(obogrevateliDto.getMaxMohch());
        obogrevateli.setRekSqr(obogrevateliDto.getRekSqr());
        obogrevateli.setNaprPit(obogrevateliDto.getNaprPit());
        obogrevateli.setPrice(obogrevateliDto.getPrice());
        return obogrevateli;
    }
    public ObogrevateliDto fromObToObDto(Obogrevateli obogrevateli){
        return ObogrevateliDto.builder()
                .id(obogrevateli.getId())
                .name(obogrevateli.getName())
                .color(obogrevateli.getColor())
                .maxMohch(obogrevateli.getMaxMohch())
                .rekSqr(obogrevateli.getRekSqr())
                .naprPit(obogrevateli.getNaprPit())
                .price(obogrevateli.getPrice())
                .build();
    }

    public Konvektori fromKoDtoToKo (KonvektoriDto konvektoriDto){
        Konvektori konvektori = new Konvektori();
        konvektori.setId(konvektoriDto.getId());
        konvektori.setName(konvektoriDto.getName());
        konvektori.setColor(konvektoriDto.getColor());
        konvektori.setMaxMohch(konvektoriDto.getMaxMohch());
        konvektori.setRekSqr(konvektoriDto.getRekSqr());
        konvektori.setNaprPit(konvektoriDto.getNaprPit());
        konvektori.setPrice(konvektoriDto.getPrice());
        return konvektori;
    }
    public KonvektoriDto fromKoToKoDto(Konvektori konvektori){
        return KonvektoriDto.builder()
                .id(konvektori.getId())
                .name(konvektori.getName())
                .color(konvektori.getColor())
                .maxMohch(konvektori.getMaxMohch())
                .rekSqr(konvektori.getRekSqr())
                .naprPit(konvektori.getNaprPit())
                .price(konvektori.getPrice())
                .build();
    }

    public Comment fromCDtoToC(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setRate(commentDto.getRate());
        comment.setComment(commentDto.getComment());
        comment.setName(commentDto.getName());
        return comment;
    }
    public CommentDto fromCToCDto(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .rate(comment.getRate())
                .comment(comment.getComment())
                .name(comment.getName())
                .build();
    }
}
