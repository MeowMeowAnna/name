package com.example.Pribori.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ObogrevateliDto {

    protected Long id;
    protected String name;

    private String color;
    private Long maxMohch;
    private Long rekSqr;
    private Long naprPit;
    protected String price;

    @Builder
    public ObogrevateliDto(Long id,String name,String color,Long maxMohch,Long rekSqr,Long naprPit,String price){
        this.id = id;
        this.name = name;
        this.color = color;
        this.maxMohch = maxMohch;
        this.rekSqr = rekSqr;
        this.naprPit = naprPit;
        this.price = price;
    }
}
