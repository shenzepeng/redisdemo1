package com.example.redisdemo1.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Car {
    private Long id;
    private String color;
    private Integer length;
    private Integer width;
    private Double price;
}
