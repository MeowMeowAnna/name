package com.example.Pribori.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "konvektori")
@Data
@NoArgsConstructor
public class Konvektori {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "maxMohch")
    private Long maxMohch;

    @Column(name = "rekSqr")
    private Long rekSqr;

    @Column(name = "naprPit")
    private Long naprPit;

    @Column(name = "price")
    protected String price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}