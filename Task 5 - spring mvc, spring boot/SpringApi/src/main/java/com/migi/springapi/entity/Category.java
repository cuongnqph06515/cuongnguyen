package com.migi.springapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "loaihang")
public class Category {

    @Id
    @Column(name = "maloaihang")
    private Integer categoryCode;

    @Column(name = "tenloaihang")
    private String categoryName;

}
